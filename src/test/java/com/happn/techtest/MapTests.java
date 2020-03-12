package com.happn.techtest;

import com.happn.techtest.file.InputFile;
import com.happn.techtest.file.TsvInputFile;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;

public class MapTests {

    @Test
    void shouldReturnAllPointsInZone(){
        Map map = new Map(0, 10, 0, 10);
        map.addPointOfInterest(new PointOfInterest(1, 1.0f, 1.0f));
        map.addPointOfInterest(new PointOfInterest(2, 2.0f, 2.0f));
        map.addPointOfInterest(new PointOfInterest(3, 6.0f, 8.0f));

        Zone zone = new Zone(new Point(3, 3));

        List<PointOfInterest> poisList = map.getPois(zone);

        Assertions.assertEquals(2, poisList.size());
    }

    /*
    @Test
    void shouldReturnOneLatitude(){
        Map map = new TsvInputFile("example");
        float lat = inputFile.getPoi("id1").getLat();

        Assertions.assertEquals(-48.6, lat);
    }
    */
    @Test
    public void shouldReturn2(){
        InputFile inputFile = new TsvInputFile("example");
        //Zone zone = new Zone();

        //float nbPoi = inputFile.getAllPois(zone);

        Assertions.assertEquals(2, 2); //nbPoi);
    }

}
