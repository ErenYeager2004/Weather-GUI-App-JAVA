import javax.swing.*;

public class App {
    public static void main(String[] args) {
        //use invoke later for thread safety
        SwingUtilities.invokeLater(() -> new WeatherAppGUI().setVisible(true));
    }
}
