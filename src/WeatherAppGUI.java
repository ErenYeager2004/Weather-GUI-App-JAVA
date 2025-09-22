import org.json.simple.JSONObject;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class WeatherAppGUI extends JFrame{

    private JSONObject weatherData;
    public WeatherAppGUI(){
        super("Weather App");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(450, 650);

        setLocationRelativeTo(null);

        setLayout(null);

        setResizable(false);

        addGuiComponents();
    }

    private void addGuiComponents(){
        JTextField searchField = new JTextField();
        searchField.setBounds(20,15,351,45);
        searchField.setFont(new Font("Dialog", Font.PLAIN, 24));
        add(searchField);

        //weather image
        JLabel weatherConditionImage = new JLabel(loadImage("src/assets/cloudy.png"));
        weatherConditionImage.setBounds(0, 125, 450, 217);
        add(weatherConditionImage);

        JLabel temperatureText = new JLabel("10 C");
        temperatureText.setBounds(0, 350, 450, 54);
        temperatureText.setFont(new Font("Dialog",Font.BOLD,48));
        temperatureText.setHorizontalAlignment(SwingConstants.CENTER);
        add(temperatureText);

        JLabel weatherConditionDESC = new JLabel("Cloudy");
        weatherConditionDESC.setBounds(0, 405, 450, 36);
        weatherConditionDESC.setFont(new Font("Dialog", Font.PLAIN, 32));
        weatherConditionDESC.setHorizontalAlignment(SwingConstants.CENTER);
        add(weatherConditionDESC);

        JLabel humidityImage = new JLabel(loadImage("src/assets/humidity.png"));
        humidityImage.setBounds(15, 500, 74, 66);
        add(humidityImage);


        JLabel humidityText = new JLabel("<html><b>Humidity</b> 100%</html>");
        humidityText.setBounds(90, 500, 85, 55);
        humidityText.setFont(new Font("Dialog", Font.PLAIN, 16));
        add(humidityText);

        JLabel windSpeed = new JLabel(loadImage("src/assets/windspeed.png"));
        windSpeed.setBounds(220, 500, 74, 66);
        add(windSpeed);

        JLabel windspeedText = new JLabel("<html><b>Windspeed</b> 15km/h</html>");
        windspeedText.setBounds(310, 500, 85, 55);
        windspeedText.setFont(new Font("Dialog",Font.PLAIN, 16));
        add(windspeedText);

        JButton searchButton = new JButton(loadImage("src/assets/search.png"));

        //change the cursor to hand
        searchButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        searchButton.setBounds(375, 15, 47, 45);
        searchButton.addActionListener((e)->{
            String userInput = searchField.getText().trim();
            weatherData = WeatherApp.getWeatherData(userInput);

            String weatherCondition = (String) weatherData.get("weather_condition");

            switch (weatherCondition){
                case "Clear" :
                    weatherConditionImage.setIcon(loadImage("src/assets/clear.png"));
                    break;
                case "Cloudy" :
                    weatherConditionImage.setIcon(loadImage("src/assets/cloudy.png"));
                    break;
                case "Rain" :
                    weatherConditionImage.setIcon(loadImage("src/assets/rain.png"));
                    break;
                case "Snow" :
                    weatherConditionImage.setIcon(loadImage("src/assets/snow.png"));
                    break;
            }
            double temperature = (double) weatherData.get("temperature");
            temperatureText.setText(temperature + " C");

            weatherConditionDESC.setText(weatherCondition);

            long humidity =  (long) weatherData.get("humidity");
            humidityText.setText("<html><b>Humidity</b> " + humidity + "%</html>");

            double windspeed =  (double) weatherData.get("windspeed");
            windspeedText.setText("<html><b>Windspeed</b> " + windspeed + "km/h</html>");
        });
        add(searchButton);
    }

    private ImageIcon loadImage(String path) {
        try{
            BufferedImage image = ImageIO.read(new File(path));
            return new ImageIcon(image);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("Could not load the file");
        return null;
    }
}
