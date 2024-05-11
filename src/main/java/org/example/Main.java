package org.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {

    private static final Logger LOG = LoggerFactory.getLogger(Main.class);
    public static void main(String[] args) {
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        LOG.info("availableProcessors : {} ",availableProcessors);
    }
}