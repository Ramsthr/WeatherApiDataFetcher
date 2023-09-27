package Methods;

import org.json.JSONArray;
import org.json.JSONObject;



public class Functions implements Methodsfunc {

    private final JSONObject weatherdata;
    private  String[] selectedops={"main","pressure"};

    private final JSONArray list;
    public Functions(final JSONObject weatherdata) {
        this.weatherdata= weatherdata;
         this.list = this.weatherdata.getJSONArray("list");
    }

    public void selectionofops(String ops){
        if(ops=="1"){
            selectedops= new String[]{"main", "temp"};
        } else if (ops=="2") {
            selectedops= new String[]{"wind", "speed"};
        }
    }
    @Override
    public double methods(String datetime) {
        for (int i = 0; i < list.length(); i++) {
            JSONObject forecast = list.getJSONObject(i);
            String forecastDateTime = forecast.getString("dt_txt");
            if (forecastDateTime.equals(datetime)) {
                JSONObject object = forecast.getJSONObject(selectedops[0]);
                return object.getDouble(selectedops[1]);
            }
        }
        return -1;
    }
}
