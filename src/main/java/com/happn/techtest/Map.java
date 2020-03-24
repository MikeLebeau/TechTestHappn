package com.happn.techtest;

import com.happn.techtest.point.PointOfInterest;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Map {
    private float minLat = Config.LAT_MIN.getValue();
    private float maxLat = Config.LAT_MAX.getValue();
    private float minLon = Config.LON_MIN.getValue();
    private float maxLon = Config.LON_MAX.getValue();

    private List<Float> listLon, listLat;

    private List<PointOfInterest> pointOfInterestList;

    public Map(){
        initializeMap();
    }

    public Map(float minLat, float maxLat, float minLon, float maxLon) {
        this.minLat = minLat;
        this.maxLat = maxLat;
        this.minLon = minLon;
        this.maxLon = maxLon;

        initializeMap();
    }

    private void initializeMap(){
        // *2 because of the 0.5 step
        // +1 to be sure to have all
        int rangeLat = (int)((Math.abs(this.minLat) + Math.abs(this.maxLat)) * 2) + 1;
        this.listLat = new ArrayList<>(rangeLat);

        int rangeLon = (int)((Math.abs(this.minLon) + Math.abs(this.maxLon)) * 2) + 1;
        this.listLon = new ArrayList<>(rangeLon);


        float tmp = minLat;
        for (int i = 0; i <= rangeLat; i++) {
            listLat.add(tmp);
            tmp += 0.5;
        }

        tmp = minLon;
        for (int i = 0; i <= rangeLon; i++) {
            listLon.add(tmp);
            tmp += 0.5;
        }

        this.pointOfInterestList = new ArrayList<>();
    }

    public float getMinLon() {
        return minLon;
    }

    public void setMinLon(float minLon) {
        this.minLon = minLon;
    }

    public float getMaxLon() {
        return maxLon;
    }

    public void setMaxLon(float maxLon) {
        this.maxLon = maxLon;
    }

    public float getMinLat() {
        return minLon;
    }

    public void setMinLat(int minLat) {
        this.minLon = minLat;
    }

    public float getMaxLat() {
        return maxLon;
    }

    public void setMaxLat(int maxLat) {
        this.maxLon = maxLat;
    }

    public List<PointOfInterest> getPois() {
        return pointOfInterestList;
    }

    public void addPointOfInterest(PointOfInterest point) {
        this.pointOfInterestList.add(point);
    }

    public List<Float> getListLon() {
        return listLon;
    }

    public void setListLon(List<Float> listLon) {
        this.listLon = listLon;
    }

    public List<Float> getListLat() {
        return listLat;
    }

    public void setListLat(List<Float> listLat) {
        this.listLat = listLat;
    }

    public List<PointOfInterest> getPois(Zone zone){
        return this.pointOfInterestList.stream()
                .filter((pointOfInterest ->
                        pointOfInterest.getLat() >= zone.getBottomLeft().getLat()
                        && pointOfInterest.getLat() <= zone.getTopRight().getLat()
                        && pointOfInterest.getLon() >= zone.getBottomLeft().getLon()
                        && pointOfInterest.getLon() <= zone.getTopRight().getLon()
                )).collect(Collectors.toList());
    }

    public PointOfInterest getPoi(String id){
        return this.pointOfInterestList.stream()
                .filter((point) -> id.equals(point.getId()))
                .findFirst().get();
    }


    enum Config {
        LAT_MIN(-90),
        LAT_MAX(90),
        LON_MIN(-180),
        LON_MAX(180);

        private float value;

        Config(float name){
            this.value = name;
        }

        public float getValue(){
            return value;
        }
    }
}
