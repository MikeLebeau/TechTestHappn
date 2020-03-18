package com.happn.techtest.file;

import com.happn.techtest.Map;
import com.happn.techtest.point.PointOfInterest;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class TsvInputFile implements InputFile {

    private String fileName;

    public TsvInputFile(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public Map createMap() {

        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource(this.fileName + ".tsv").getFile());

        Map newMap = null;

        try(Stream<String> stream = Files.lines(Paths.get(file.getAbsolutePath()))){

            Map tmpMap = new Map(-90, 90, -180, 180);

            stream
                    .skip(1) // Skip header
                    .map((line) -> line.split("\\s+"))
                    .forEach((line) -> tmpMap.addPointOfInterest(new PointOfInterest(line[0], Float.parseFloat(line[1]), Float.parseFloat(line[2]))));
            ;

            newMap = tmpMap;

        } catch (IOException e) {
            e.printStackTrace();
        }

        return newMap;
    }
}
