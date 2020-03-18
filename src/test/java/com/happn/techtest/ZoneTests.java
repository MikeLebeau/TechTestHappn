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
    void shouldReturnBottomLeftPoint(){
        Assertions.assertEquals(new Point(0, 0), zone.getBottomLeft());
    }

    @Test
    void shouldReturnBottomRightPoint(){
        Assertions.assertEquals(new Point(0, 1), zone.getBottomRight());
    }

    @Test
    void shouldReturnTopLeftPoint(){
        Assertions.assertEquals(new Point(1, 0), zone.getTopLeft());
    }

    @Test
    void shouldReturnTopRightPoint(){
        Assertions.assertEquals(new Point(1, 1), zone.getTopRight());
    }


}
