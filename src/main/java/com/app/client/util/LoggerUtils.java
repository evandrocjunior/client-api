package com.app.client.util;

import com.app.client.presentation.controller.ClientController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoggerUtils {

    private static final Logger LOGGER = LoggerFactory.getLogger(ClientController.class);

    public static void logInfo(String message, Class clazz) {
        LOGGER.info(message, clazz);
    }
}
