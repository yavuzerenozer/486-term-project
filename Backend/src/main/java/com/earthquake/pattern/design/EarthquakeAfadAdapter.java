package com.earthquake.pattern.design;

public class EarthquakeAfadAdapter extends Earthquake{

    public EarthquakeAfadAdapter(EarthquakeAfad earthquakeAfad) {

        this.set_id(earthquakeAfad.getEventId());
        this.setDate(earthquakeAfad.getTime().split(" ")[0]);
        this.setTime(earthquakeAfad.getTime().split(" ")[1]);
        this.setDepth(earthquakeAfad.getDepth());
        this.setLat(earthquakeAfad.getLat());
        this.setLng(earthquakeAfad.getLon());
        this.setMl(earthquakeAfad.getML());
        this.setType("1");
    }

}
