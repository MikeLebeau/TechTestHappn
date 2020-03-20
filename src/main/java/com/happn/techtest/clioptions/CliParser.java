package com.happn.techtest.clioptions;

import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;

public class CliParser {

    public static CommandLineParser getDefaultCliParser(){
        return new DefaultParser();
    }

}
