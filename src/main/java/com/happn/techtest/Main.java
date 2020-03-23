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
            final CommandLine cmd = parser.parse(options, args, true);

            if(cmd.hasOption("help")){
                HelpFormatter formatter = new HelpFormatter();
                formatter.printHelp( "TechTestHappn", options );
                System.exit(0);
            }

            StringBuilder result = new StringBuilder("{\n");

            if(cmd.hasOption("nbpoi")){
                Zone zone = Zone.fromJson(cmd.getOptionValue("nbpoi"));

                InputFile inputFile = new TsvInputFile("example");

                Map map = inputFile.createMap();

                result.append("\t\"value\": ");
                result.append(map.getPois(zone).size());
                result.append("\n");
            }

            result.append("}\n");

            System.out.println(result.toString());
        } catch (ParseException | JsonProcessingException e) {
            e.printStackTrace();
        }
    }
}
