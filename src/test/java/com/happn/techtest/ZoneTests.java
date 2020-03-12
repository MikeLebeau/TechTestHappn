package com.happn.techtest;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ZoneTests {

    @Test
    @DisplayName("Check if the getAllSortedPoint work well")
    void shouldReturnSortedPointArray(){
        Point[] arr = new Point[4];
        arr[0] = new Point(1, 1);
        arr[1] = new Point(0, 0);
        arr[2] = new Point(0, 1);
        arr[3] = new Point(1, 0);

        Zone zone = new Zone(arr);


        Point[] sortedArr = {
                new Point(0, 0),
                new Point(0, 1),
                new Point(1, 0),
                new Point(1, 1)
        };

        Assertions.assertArrayEquals(sortedArr, zone.getAllSortedPoints());
    }

    @Test
    void shouldReturnBottomLeftPoint(){
        Zone zone = new Zone(new Point(3, 3));
        Assertions.assertEquals(new Point(0, 0), zone.getBottomLeft());
    }

    @Test
    void shouldReturnTopRightPoint(){
        Zone zone = new Zone(new Point(3, 3));
        Assertions.assertEquals(new Point(3, 3), zone.getTopRight());
    }

}
