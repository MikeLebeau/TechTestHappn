package com.happn.techtest;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.happn.techtest.clioptions.CliOptions;
import com.happn.techtest.file.InputFile;
import com.happn.techtest.file.TsvInputFile;
import org.apache.commons.cli.*;

import java.util.Arrays;
import java.util.Collections;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello Happn!");

        final Options options = CliOptions.getOptions();

        final CommandLineParser parser = new DefaultParser();

        try {
            System.out.println("ARGS: " + Arrays.toString(args));
            final CommandLine cmd = parser.parse(options, args);



            HelpFormatter formatter = new HelpFormatter();
            formatter.printHelp( "lol", options );


            Zone zone = Zone.fromJson(cmd.getOptionValue("nbpoi"));

            System.out.println("L'option zone: " + zone);

            InputFile inputFile = new TsvInputFile("example");
            Map map = inputFile.createMap();

            System.out.println("getPois: " + map.getPois(zone).size());
        } catch (ParseException | JsonProcessingException e) {
            e.printStackTrace();
        }
    }
}
