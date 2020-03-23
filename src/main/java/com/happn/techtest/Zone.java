package com.happn.techtest;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.happn.techtest.point.Point;

import java.io.Serializable;
import java.util.Arrays;

@JsonDeserialize(builder = Zone.Builder.class)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Zone {

    private Point[] allPoints = new Point[4];

    public Zone (float minLat, float maxLat, float minLon, float maxLon){
        this.allPoints[0] = new Point(minLat, minLon);
        this.allPoints[1] = new Point(minLat, maxLon);
        this.allPoints[2] = new Point(maxLat, minLon);
        this.allPoints[3] = new Point(maxLat, maxLon);
    }

    public Zone(Point bottomLeft, Point topLeft, Point topRight, Point bottomRight){
        this.allPoints[0] = bottomLeft;
        this.allPoints[1] = bottomRight;
        this.allPoints[2] = topLeft;
        this.allPoints[3] = topRight;
    }

    public Zone(Point topRight){
        this.allPoints[0] = new Point(0, 0);
        this.allPoints[1] = new Point(0, topRight.getLon());
        this.allPoints[2] = new Point(topRight.getLat(), 0);
        this.allPoints[3] = topRight;
    }

    public Zone(Point[] allPoints) {
        Arrays.sort(allPoints);
        for (int i = 0; i < 4; i++) {
            this.allPoints[i] = allPoints[i];
        }
    }

    public Point[] getAllPoints() {
        return allPoints;
    }

    public void setAllPoints(Point[] allPoints) {
        this.allPoints = allPoints;
    }



    public Point getBottomLeft(){
        return allPoints[0];
    }

    public void setBottomLeft(Point p){
        allPoints[0] = p;
    }



    public Point getBottomRight(){
        return allPoints[1];
    }

    public void setBottomRight(Point p){
        allPoints[1] = p;
    }



    public Point getTopLeft(){
        return allPoints[2];
    }

    public void setTopLeft(Point p){
        allPoints[2] = p;
    }



    public Point getTopRight(){
        return allPoints[3];
    }

    public void setTopRight(Point p){
        allPoints[3] = p;
    }



    public float getMinLat(){
        return allPoints[0].getLat();
    }

    public float getMaxLat(){
        return allPoints[3].getLat();
    }

    public float getMinLon(){
        return allPoints[0].getLon();
    }

    public float getMaxLon(){
        return allPoints[3].getLon();
    }


    @Override
    public String toString() {
        return "Zone{" +
                "allPoints=" + Arrays.toString(allPoints) +
                '}';
    }

    public String toJson() throws JsonProcessingException {
        ObjectMapper om = new ObjectMapper();
        return om.writeValueAsString(this);
    }


    public static Zone fromJson(String json) throws JsonProcessingException {
        ObjectMapper om = new ObjectMapper();
        return om.readValue(json, Zone.class);
    }


    @JsonPOJOBuilder(buildMethodName = "build", withPrefix = "set")
    public static class Builder{

        @JsonProperty("min_lat")
        float minLat = -90;

        @JsonProperty("max_lat")
        float maxLat = 90;

        @JsonProperty("min_lon")
        float minLon = -180;

        @JsonProperty("max_lon")
        float maxLon = 180;

        public void setMinLat(float minLat) {
            this.minLat = minLat;
        }

        public void setMaxLat(float maxLat) {
            this.maxLat = maxLat;
        }

        public void setMinLon(float minLon) {
            this.minLon = minLon;
        }

        public void setMaxLon(float maxLon) {
            this.maxLon = maxLon;
        }

        public Zone build(){
            return new Zone(minLat, maxLat, minLon, maxLon);
        }
    }
}


