package com.earthquake.pattern.design;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class EarthquakeAfad {

    private String eventId;
    private String time;
    private String agency;
    private String rms;
    private String lat;
    private String lon;
    private String depth;
    private String ML;
    private String country;
    private String city;
    private String other;


}
