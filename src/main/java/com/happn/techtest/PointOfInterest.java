package com.happn.techtest;

public class PointOfInterest extends Point {
    int id;

    public PointOfInterest(int id, float lat, float lon) {
        super(lat, lon);
        this.id = id;
    }

    public int getId() {
        return id;
    }

}
