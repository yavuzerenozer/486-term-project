package com.earthquake.pattern.design;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@AllArgsConstructor
@Service
public class EarthquakeService {

    private final EarthquakeRepository earthquakeRepository;

    public List<Earthquake> getAllEarthquakes() {
        return earthquakeRepository.findAll();
    }
}
