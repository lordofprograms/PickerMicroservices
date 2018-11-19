package com.pickers.microservices.save.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = LogModel.COLLECTION_NAME)
public class LogModel {
    public static final String COLLECTION_NAME = "logs";

    @Id
    private Long id;
    private double latitude;
    private double longitude;
    private int height;
    private int roll;
    private int pitch;
    private int yaw;

    public LogModel() {
    }

    public LogModel(Long id, double latitude, double longitude, int height, int roll, int pitch, int yaw) {
        this.id = id;
        this.latitude = latitude;
        this.longitude = longitude;
        this.height = height;
        this.roll = roll;
        this.pitch = pitch;
        this.yaw = yaw;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getRoll() {
        return roll;
    }

    public void setRoll(int roll) {
        this.roll = roll;
    }

    public int getPitch() {
        return pitch;
    }

    public void setPitch(int pitch) {
        this.pitch = pitch;
    }

    public int getYaw() {
        return yaw;
    }

    public void setYaw(int yaw) {
        this.yaw = yaw;
    }
}
