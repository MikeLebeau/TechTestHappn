package com.happn.techtest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Map {
    int minX, maxX;
    int minY, maxY;

    List<Float> listX, listY;

    List<PointOfInterest> pointOfInterestList;

    public Map(int minX, int maxX, int minY, int maxY) {
        this.minX = minX;
        this.maxX = maxX;
        this.minY = minY;
        this.maxY = maxY;

        int rangeX = (Math.abs(this.minX) + Math.abs(this.maxX)) * 2; // Car il y a un pas de 0.5
        this.listX = new ArrayList<>(rangeX);

        int rangeY = (Math.abs(this.minY) + Math.abs(this.maxY)) * 2; // Car il y a un pas de 0.5
        this.listY = new ArrayList<>(rangeY);

        float tmp = minX;
        for (int i = 0; i <= rangeX; i++) {
            listX.add(tmp);
            tmp += 0.5;
        }

        tmp = minY;
        for (int i = 0; i <= rangeY; i++) {
            listY.add(tmp);
            tmp += 0.5;
        }

        this.pointOfInterestList = new ArrayList<>();
    }

    public int getMinX() {
        return minX;
    }

    public void setMinX(int minX) {
        this.minX = minX;
    }

    public int getMaxX() {
        return maxX;
    }

    public void setMaxX(int maxX) {
        this.maxX = maxX;
    }

    public int getMinY() {
        return minY;
    }

    public void setMinY(int minY) {
        this.minY = minY;
    }

    public int getMaxY() {
        return maxY;
    }

    public void setMaxY(int maxY) {
        this.maxY = maxY;
    }

    public List<PointOfInterest> getPois() {
        return pointOfInterestList;
    }

    public void addPointOfInterest(PointOfInterest point) {
        this.pointOfInterestList.add(point);
    }

    public List<Float> getListX() {
        return listX;
    }

    public void setListX(List<Float> listX) {
        this.listX = listX;
    }

    public List<Float> getListY() {
        return listY;
    }

    public void setListY(List<Float> listY) {
        this.listY = listY;
    }

    public void drawMap(){
        System.out.print(String.format("%4c|", '+'));
        System.out.println("ListX size: " + this.listX.size());
        for(float x : this.listX) { // Afficher les X
            System.out.print(String.format("%5.1f|", x));
        }

        /*System.out.println("");

        for(int j = 0; j < (Math.abs(minX)+Math.abs(maxX))*5; j += 0.5) { // Separator
            System.out.print("-");
        }

        System.out.println("");

        for(int i = maxY; i >= minY; i -= 0.5){
            System.out.print(String.format("%4d|", i));

            for(int j = maxX; j >= minX; j -= 0.5) {
                System.out.print(String.format("%4d|", j));
            }
            System.out.println(""); // end of line
        }*/
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

}
