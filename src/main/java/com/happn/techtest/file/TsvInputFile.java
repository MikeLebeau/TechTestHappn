package com.happn.techtest.file;

import com.happn.techtest.Map;
import com.happn.techtest.PointOfInterest;
import com.happn.techtest.Zone;

public class TsvInputFile implements InputFile {

    private String fileName;

    public TsvInputFile(String fileName) {
        this.fileName = fileName;
    }


    @Override
    public Map createMap() {
        return null;
    }
}
