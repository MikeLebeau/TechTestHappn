package com.happn.techtest;

import com.happn.techtest.clioptions.CliOptions;
import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello Happn!");

        final Options options = CliOptions.getOptions();

        final CommandLineParser parser = new DefaultParser();

        try {
            final CommandLine line = parser.parse(options, args);

            int nbpoi = Integer.parseInt(line.getOptionValue("nbpoi", "0"));
            System.out.println("L'option nbpoi: " + nbpoi);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
