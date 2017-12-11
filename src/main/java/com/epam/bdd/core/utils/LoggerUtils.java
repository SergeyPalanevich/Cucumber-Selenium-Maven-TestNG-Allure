package com.epam.bdd.core.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LoggerUtils {

    private static final Logger LOGGER = LogManager.getRootLogger();

    private LoggerUtils() {
    }

    public static void error(String string) {
        LOGGER.error(string);
    }

    public static void error(String string, Throwable throwable) {
        LOGGER.error(string, throwable);
    }

    public static void debug(String string) {
        LOGGER.debug(string);
    }

    public static void info(String message) {
        LOGGER.info(message);
    }
}
