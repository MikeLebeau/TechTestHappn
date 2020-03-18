package com.happn.techtest;

import com.happn.techtest.point.Point;

import java.util.Arrays;

public class Zone {

    private Point[] allPoints = new Point[4];

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

    public Point getBottomRight(){
        return allPoints[1];
    }

    public Point getTopLeft(){
        return allPoints[2];
    }

    public Point getTopRight(){
        return allPoints[3];
    }
}
