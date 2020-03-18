package com.happn.techtest;

import java.util.Objects;

public class Point implements Comparable<Point> {

    private float lon, lat;

    public Point(float lon, float lat) {
        this.lat = lat;
        this.lon = lon;
    }

    public float getLat() {
        return lat;
    }

    public void setLat(float lat) {
        this.lat = lat;
    }

    public float getLon() {
        return lon;
    }

    public void setLon(float lon) {
        this.lon = lon;
    }

    @Override
    public String toString() {
        return "Point{" +
                "lon=" + lon +
                ", lat=" + lat +
                '}';
    }

    @Override
    public int compareTo(Point otherPoint) {
        int me = (int)(this.lon * 2 + this.lat);
        int other = (int)(otherPoint.lon * 2 + otherPoint.lat);
        return me - other;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Point)) return false;
        Point point = (Point) o;
        return Float.compare(point.lon, lon) == 0 &&
                Float.compare(point.lat, lat) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(lon, lat);
    }
}
