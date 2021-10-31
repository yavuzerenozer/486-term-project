package com.earthquake.pattern.design;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface EarthquakeRepository extends MongoRepository<Earthquake, String> {
}
