package com.happn.techtest;

import com.happn.techtest.point.Point;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ZoneTests {

    static Zone zone = null;

    @BeforeAll
    static void initialize(){
        Point[] arr = new Point[4];
        arr[0] = new Point(1, 1);
        arr[1] = new Point(0, 0);
        arr[2] = new Point(0, 1);
        arr[3] = new Point(1, 0);

        zone = new Zone(arr);
    }

    @Test
    @DisplayName("Check if the getAllSortedPoint work well")
    void shouldReturnSortedPointArray(){
        Point[] sortedArr = {
                new Point(0, 0),
                new Point(0, 1),
                new Point(1, 0),
                new Point(1, 1)
        };

        Assertions.assertArrayEquals(sortedArr, zone.getAllPoints());
    }

    @Test
    @DisplayName("Check if I get the lowest point, the bottom left point")
    void shouldReturnBottomLeftPoint(){
        Assertions.assertEquals(new Point(0, 0), zone.getBottomLeft());
    }

    @Test
    @DisplayName("Check if I get the bottom right point")
    void shouldReturnBottomRightPoint(){
        Assertions.assertEquals(new Point(0, 1), zone.getBottomRight());
    }

    @Test
    @DisplayName("Check if I get the top left point")
    void shouldReturnTopLeftPoint(){
        Assertions.assertEquals(new Point(1, 0), zone.getTopLeft());
    }

    @Test
    @DisplayName("Check if I get the top right point")
    void shouldReturnTopRightPoint(){
        Assertions.assertEquals(new Point(1, 1), zone.getTopRight());
    }

    @Test
    @DisplayName("Check if I get the min lat")
    void shouldReturnMinLatEqual0(){
        Assertions.assertEquals(0, zone.getMinLat());
    }

    @Test
    @DisplayName("Check if I get the min lon")
    void shouldReturnMinLonEqual0(){
        Assertions.assertEquals(0, zone.getMinLon());
    }

    @Test
    @DisplayName("Check if I get the max lat")
    void shouldReturnMaxLatEqual1(){
        Assertions.assertEquals(1, zone.getMaxLat());
    }

    @Test
    @DisplayName("Check if I get the max lon")
    void shouldReturnMaxLonEqual1(){
        Assertions.assertEquals(1, zone.getMaxLon());
    }
}
