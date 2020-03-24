package com.happn.techtest;

import com.happn.techtest.file.InputFile;
import com.happn.techtest.file.TsvInputFile;
import com.happn.techtest.point.PointOfInterest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class FileTypeTests {

    @Test
    @DisplayName("Check if I create something from an tsv file")
    void shouldCreateAMapFromTSVFile(){
        InputFile inputFile = new TsvInputFile("example");
        Map map = inputFile.createMap();

        Assertions.assertNotNull(map);
    }

    @Test
    @DisplayName("Check if I create something good from an tsv file")
    void verifyPointWithId1(){
        InputFile inputFile = new TsvInputFile("example");
        Map map = inputFile.createMap();

        Assertions.assertEquals(new PointOfInterest("id1", -48.6f, -37.7f), map.getPoi("id1"));
    }

    @Test
    @DisplayName("Check if I create something good from an tsv file (2nd test)")
    void shouldReturn2(){
        InputFile inputFile = new TsvInputFile("example");
        Map map = inputFile.createMap();
        Zone zone = new Zone(6.5f, map.getMaxLat(), -7, map.getMaxLon());

        Assertions.assertEquals(2, map.getPois(zone).size());
    }
}
