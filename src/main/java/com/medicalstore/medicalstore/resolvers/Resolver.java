package com.medicalstore.medicalstore.resolvers;

import com.medicalstore.medicalstore.handlers.Handler;

/**
 * This class serves as a dependency injection container for the application.
 * Add any required dependencies here.
 */
public class Resolver {
    private final Handler handler;

    public Resolver(Handler handler) {
        this.handler = handler;
    }

    public Handler getHandler() {
        return handler;
    }
}
