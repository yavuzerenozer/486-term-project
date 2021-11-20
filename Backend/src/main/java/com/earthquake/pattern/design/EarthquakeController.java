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
        //List<Earthquake> earthquakes = earthquakeService.getAllEarthquakes();
        EarthquakeAfadService earthquakeAfadService = new EarthquakeAfadService();
        List<EarthquakeAfad> earthquakeAfads = earthquakeAfadService.giveEarthquakeAfads();
        List<Earthquake> earthquakes = new ArrayList<>();
        for(int i=0; i < earthquakeAfads.size(); i++){
            EarthquakeAfadAdapter earthquakeAfadAdapter = new EarthquakeAfadAdapter(earthquakeAfads.get(i));
            earthquakeAfadAdapter.show();
            earthquakes.add(earthquakeAfadAdapter);
        }
        return earthquakes;
    }

}
