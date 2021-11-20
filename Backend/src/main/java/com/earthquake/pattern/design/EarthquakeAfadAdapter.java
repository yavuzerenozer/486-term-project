package com.earthquake.pattern.design;

public class EarthquakeAfadAdapter extends Earthquake{

    private EarthquakeAfad earthquakeAfad;

    public EarthquakeAfadAdapter(EarthquakeAfad earthquakeAfad) {

        this.earthquakeAfad = earthquakeAfad;
    }

    @Override
    public void show(){
        this.set_id(earthquakeAfad.getEventId());
        this.setDate(earthquakeAfad.getTime().split(" ")[0]);
        this.setTime(earthquakeAfad.getTime().split(" ")[1]);
        this.setDepth(earthquakeAfad.getDepth());
        this.setLat(earthquakeAfad.getLat());
        this.setLng(earthquakeAfad.getLon());
        this.setMl(earthquakeAfad.getML());
        this.setType("ilksel");
        System.out.println(this);
    }
}
