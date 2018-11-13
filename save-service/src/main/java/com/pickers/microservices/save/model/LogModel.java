package com.pickers.microservices.save.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "logs")
public class LogModel {

    // there will be Integer or String, hmm
    @Id
    private String id;
    private long latitude;
    private long longitude;
    private int height;

    public LogModel() {
    }

    public LogModel(String id, long latitude, long longitude, int height) {
        this.id = id;
        this.latitude = latitude;
        this.longitude = longitude;
        this.height = height;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public long getLatitude() {
        return latitude;
    }

    public void setLatitude(long latitude) {
        this.latitude = latitude;
    }

    public long getLongitude() {
        return longitude;
    }

    public void setLongitude(long longitude) {
        this.longitude = longitude;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
}
