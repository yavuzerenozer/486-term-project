package com.earthquake.pattern.design;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Earthquake {

    @Id
    private String _id;
    private String date;
    private String time;
    private String lat;
    private String lng;
    private String depth;
    private String ml;
    private String type;


}
