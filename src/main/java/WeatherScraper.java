import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class WeatherScraper {
    public static void main(String[] args) {
        try {
            // Connect to the weather website
            Document doc = Jsoup.connect("https://weather.com/").get();

            // Example: Extract city names and temperatures (adjust selectors)
            List<String> cities = new ArrayList<>();
            List<String> temperatures = new ArrayList<>();

            Elements cityElements = doc.select(".city-class"); // Update selector based on the website's HTML
            Elements tempElements = doc.select(".temp-class"); // Update selector based on the website's HTML

            for (Element city : cityElements) {
                cities.add(city.text());
            }

            for (Element temp : tempElements) {
                temperatures.add(temp.text());
            }

            // Save data to CSV
            try (FileWriter writer = new FileWriter("weather_data.csv")) {
                writer.write("City,Temperature\n");
                for (int i = 0; i < cities.size(); i++) {
                    writer.write(cities.get(i) + "," + temperatures.get(i) + "\n");
                }
            }

            System.out.println("Data scraped and saved to weather_data.csv");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

