package com.earthquake.pattern.design;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

public class EarthquakeAfadService {

    private List<EarthquakeAfad> earthquakeAfads;
    private final String uri = "https://www.mertkose.net/api/son-depremler/";

    public EarthquakeAfadService(List<EarthquakeAfad> earthquakeAfadList){
            this.earthquakeAfads = earthquakeAfadList;
        }

    public List<EarthquakeAfad> giveEarthquakeAfads() {
        List<EarthquakeAfad> earthquakeAfadList = new ArrayList<EarthquakeAfad>();
        RestTemplate restTemplate = new RestTemplate();
        String result = restTemplate.getForObject(this.uri, String.class);
        JSONObject json = new JSONObject(result);
        JSONArray jsonarray = json.getJSONArray("data");

        for (int i = 0; i < jsonarray.length(); i++) {
            EarthquakeAfad earthquakeAfad = new EarthquakeAfad();
            JSONObject object = jsonarray.getJSONObject(i);
            earthquakeAfad.setAgency(object.getString("agency"));
            earthquakeAfad.setCity(object.getString("city"));
            earthquakeAfad.setCountry(object.getString("country"));
            earthquakeAfad.setDepth(object.getString("depth"));
            earthquakeAfad.setLat(object.getString("lat"));
            earthquakeAfad.setLon(object.getString("lon"));
            earthquakeAfad.setEventId(object.getString("eventId"));
            earthquakeAfad.setTime(object.getString("time"));
            earthquakeAfad.setML(object.getString("m"));
            earthquakeAfad.setOther(object.getString("other"));
            earthquakeAfad.setRms(object.getString("rms"));
            earthquakeAfadList.add(earthquakeAfad);
        }
        return earthquakeAfadList;
    }

    public List<EarthquakeAfad> getEarthquakeAfads() {
        return earthquakeAfads;
    }

    public void setEarthquakeAfads(List<EarthquakeAfad> earthquakeAfads) {
        this.earthquakeAfads = earthquakeAfads;
    }
}

