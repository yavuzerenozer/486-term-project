package com.earthquake.pattern.design;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
public class EarthquakeController {

    private final EarthquakeService earthquakeService;

    @CrossOrigin(origins = "*")
    @GetMapping("/")
    public List<Earthquake> GetEarthquakes() {
        //return earthquakeService.getAllEarthquakes();
        List<EarthquakeAfad> earthquakeAfads = new ArrayList<EarthquakeAfad>();
        EarthquakeAfadService earthquakeAfadService = new EarthquakeAfadService(earthquakeAfads);
        earthquakeAfadService.setEarthquakeAfads(earthquakeAfadService.giveEarthquakeAfads());
        earthquakeAfads=earthquakeAfadService.getEarthquakeAfads();
        List<Earthquake> earthquakes = new ArrayList<>();
        for(int i=0; i < earthquakeAfads.size(); i++){
            EarthquakeAfadAdapter earthquakeAfadAdapter = new EarthquakeAfadAdapter(earthquakeAfads.get(i));
            earthquakes.add(earthquakeAfadAdapter);
        }
        return earthquakes;
    }

}
