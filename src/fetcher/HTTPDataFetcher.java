package fetcher;

import org.json.JSONObject;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class HTTPDataFetcher implements WeatherDataFetcher {

    private final String url;
    private final String apiKey;
    public HTTPDataFetcher(final String url, final String apiKey) {
        this.url = url;
        this.apiKey = apiKey;
    }
    private String getRequest() throws IOException {
        final String baseUrl = this.url + this.apiKey;
        URL url = new URL(baseUrl);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.connect();
        Scanner scanner = new Scanner(url.openStream());
        StringBuilder response = new StringBuilder();

        while (scanner.hasNext()) {
            response.append(scanner.nextLine());
        }
        scanner.close();

        return response.toString();
    }
    @Override
    public JSONObject fetch() throws Exception {
        final String response = this.getRequest();
        return new JSONObject(response);
    }
}
