
import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;

import UI.Uiconsole;
import fetcher.HTTPDataFetcher;
import fetcher.WeatherDataFetcher;
import org.json.JSONObject;

public class Main {

    private static final String CRED_FILE_NAME = "credentials.properties";

    public static void main(String[] args) {
        try {
            final WeatherDataFetcher dataFetcher = createFetcher();
            JSONObject weatherData = dataFetcher.fetch();
            Uiconsole ui=new Uiconsole(weatherData);
            ui.run();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private static WeatherDataFetcher createFetcher() throws Exception {
        final String rootPath = System.getProperty("user.dir");
        final String sep = System.getProperty("file.separator");
        final String appConfigPath = rootPath + sep + CRED_FILE_NAME;

        Properties appProps = new Properties();
        appProps.load(new FileInputStream(appConfigPath));

        final String url = appProps.getProperty("url");
        final String apiKey = appProps.getProperty("apiKey");
        return new HTTPDataFetcher(url, apiKey);
    }
}



