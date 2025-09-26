🌦️ Simple Weather App (Java + Swing)

A lightweight weather application built with Core Java and Swing.
It fetches real-time weather data (temperature, humidity, windspeed, and condition) using the Open-Meteo API and displays it in a simple GUI.

✨ Features

🔎 Search weather by city name

🌡️ Shows temperature, humidity, windspeed, and condition

⚡ Uses Open-Meteo API (free, no API key required)

💻 Built with pure Java + Swing (no frameworks)

🪶 Lightweight & easy to run

🛠️ Technologies Used

Java 21+ (Core Java)

Swing (GUI library)

json-simple (for parsing JSON responses)

Open-Meteo API for weather & geocoding

📂 Project Structure
WeatherAppGUI/
│── src/
│   └── WeatherAppGUI.java    # Main GUI & logic
│── lib/
│   └── json-simple-1.1.1.jar # JSON parser library
│── README.md                 # Project documentation

🚀 How to Run
1. Clone the repository
   git clone https://github.com/your-username/weather-app-java.git
   cd weather-app-java

2. Add dependencies

Download json-simple-1.1.1.jar
and place it in a lib/ folder.

3. Compile the project
   javac -cp ".;lib/json-simple-1.1.1.jar" src/WeatherAppGUI.java -d out

4. Run the app
   java -cp ".;out;lib/json-simple-1.1.1.jar" WeatherAppGUI

📸 Screenshots
## 📸 Screenshots

### Main Window
![Weather App GUI](screenshots/main_window.png)

### Example: Weather in Kolkata
![Weather in Kolkata](screenshots/kolkata.png)

🔗 API Reference

Geocoding API → https://geocoding-api.open-meteo.com

Weather API → https://api.open-meteo.com
