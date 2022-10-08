package com.merce.woven.behavior.chain;

public class MyLoggerHandlerFactory {
    public static AbstractLoggerHandler getLoggerHandler(){
        AbstractLoggerHandler handler = new ErrorLoggerHandler(
                new InfoLoggerHandler(
                        new DebugLoggerHandler(null)));
        return handler;
    }
}
