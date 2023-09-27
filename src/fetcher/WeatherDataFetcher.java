package fetcher;

import org.json.JSONObject;

public interface WeatherDataFetcher {
    JSONObject fetch() throws Exception;
}
