package com.happn.techtest.point;

public class PointOfInterest extends Point {

    private String id;

    public PointOfInterest(String id, float lat, float lon) {
        super(lat, lon);
        this.id = id;
    }

    public String getId() {
        return id;
    }

}
