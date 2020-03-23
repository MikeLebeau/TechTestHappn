package com.happn.techtest;

import com.happn.techtest.point.PointOfInterest;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Map {
    private int minLat, maxLat;
    private int minLon, maxLon;

    private List<Float> listLon, listLat;

    private List<PointOfInterest> pointOfInterestList;

    public Map(int minLat, int maxLat, int minLon, int maxLon) {
        this.minLat = minLat;
        this.maxLat = maxLat;
        this.minLon = minLon;
        this.maxLon = maxLon;

        int rangeLat = (Math.abs(this.minLat) + Math.abs(this.maxLat)) * 2; // Car il y a un pas de 0.5
        this.listLat = new ArrayList<>(rangeLat);

        int rangeLon = (Math.abs(this.minLon) + Math.abs(this.maxLon)) * 2; // Car il y a un pas de 0.5
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

    public int getMinLon() {
        return minLon;
    }

    public void setMinLon(int minLon) {
        this.minLon = minLon;
    }

    public int getMaxLon() {
        return maxLon;
    }

    public void setMaxLon(int maxLon) {
        this.maxLon = maxLon;
    }

    public int getMinLat() {
        return minLon;
    }

    public void setMinLat(int minLat) {
        this.minLon = minLat;
    }

    public int getMaxLat() {
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

}
