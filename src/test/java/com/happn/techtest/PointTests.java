package com.happn.techtest;

import com.happn.techtest.point.Point;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class PointTests {

    @Test
    @DisplayName("Check if the equals implementation work well (truthy test)")
    void shouldReturnTrue(){
        Point p1 = new Point(0, 0);
        Point p2 = new Point(0,0);

        Assertions.assertEquals(p1, p2);
    }

    @Test
    @DisplayName("Check if the equals implementation work well (falsy test)")
    void shouldReturnFalse(){
        Point p1 = new Point(1, 0);
        Point p2 = new Point(0,1);

        Assertions.assertNotEquals(p1, p2);
    }

    @Test
    @DisplayName("Array sorting")
    void shouldReturnSortedArray(){
        Point[] arr = new Point[4];
        arr[0] = new Point(1, 1);
        arr[1] = new Point(0, 0);
        arr[2] = new Point(0, 1);
        arr[3] = new Point(1, 0);

        Point[] sortedArr = {
                new Point(0, 0),
                new Point(0, 1),
                new Point(1, 0),
                new Point(1, 1)
        };

        Arrays.sort(arr);
        Assertions.assertArrayEquals(sortedArr, arr);
    }

}
