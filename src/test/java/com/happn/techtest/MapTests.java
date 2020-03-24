package com.happn.techtest;

import com.happn.techtest.point.Point;
import com.happn.techtest.point.PointOfInterest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

public class MapTests {

    @Test
    @DisplayName("Check if I get the correct number of poi in a zone (2pois)")
    void shouldReturn2PointsInZone(){
        Map map = new Map(0, 10, 0, 10);
        map.addPointOfInterest(new PointOfInterest("1", 1.0f, 1.0f));
        map.addPointOfInterest(new PointOfInterest("2", 2.0f, 2.0f));
        map.addPointOfInterest(new PointOfInterest("3", 6.0f, 8.0f));

        Zone zone = new Zone(new Point(3, 3));

        List<PointOfInterest> poisList = map.getPois(zone);

        Assertions.assertEquals(2, poisList.size());
    }

    @Test
    @DisplayName("Check if I get the correct number of poi in a zone (3pois)")
    void shouldReturn3PointsInZone(){
        Map map = new Map(0, 10, 0, 10);
        map.addPointOfInterest(new PointOfInterest("1", 1.0f, 1.0f));
        map.addPointOfInterest(new PointOfInterest("2", 2.0f, 2.0f));
        map.addPointOfInterest(new PointOfInterest("3", 3.0f, 2.0f));

        Zone zone = new Zone(new Point(3, 3));

        List<PointOfInterest> poisList = map.getPois(zone);

        Assertions.assertEquals(3, poisList.size());
    }

}
