package com.happn.techtest.clioptions;

import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;

public class CliOptions {

    public static Options getOptions(){

        final Option nbPoiOption = Option.builder("nbpoi")
                .desc("Return the number of points in the given zone")
                .argName("nbpoi")
                .hasArg(true)
                .build();

        final Option densestOption = Option.builder("densest")
                .desc("Return the n densest zones")
                .argName("densest")
                .hasArg(true)
                .build();

        final Options options = new Options();

        options.addOption(nbPoiOption);
        options.addOption(densestOption);

        return options;


    }

}
