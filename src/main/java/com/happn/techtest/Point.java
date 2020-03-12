package com.happn.techtest;

import java.util.Objects;

public class Point implements Comparable<Point> {

    private float lat, lon;

    public Point(float lat, float lon) {
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
                "lat=" + lat +
                ", lon=" + lon +
                '}';
    }

    @Override
    public int compareTo(Point otherPoint) {
        int me = (int)(this.lat * 2 + this.lon);
        int other = (int)(otherPoint.lat * 2 + otherPoint.lon);
        return me - other;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Point)) return false;
        Point point = (Point) o;
        return Float.compare(point.lat, lat) == 0 &&
                Float.compare(point.lon, lon) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(lat, lon);
    }
}
