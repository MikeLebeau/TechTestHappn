package com.happn.techtest.clioptions;

import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;

public class CliOptions {

    public static Options getOptions(){

        final Option nbPoiOption = Option.builder()
                .desc("Return the number of points in the given zone")
                .longOpt("nbpoi")
                .hasArg(true)
                .argName("zone")
                .build();

        final Option densestOption = Option.builder()
                .longOpt("densest")
                .desc("(Not implemented yet) Return the n densest zones")
                .hasArg(true)
                .argName("nbZone")
                .build();

        final Options options = new Options();

        options.addOption(nbPoiOption);
        options.addOption(densestOption);
        options.addOption("h", "help", false, "This is the help ;)");

        return options;
    }

}
