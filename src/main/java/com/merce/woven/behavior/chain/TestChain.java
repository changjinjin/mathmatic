package com.merce.woven.behavior.chain;

public class TestChain {
    public static void main(String[] args) {
        //获取日志责任链
        AbstractLoggerHandler loggerHandler = MyLoggerHandlerFactory.getLoggerHandler();
        Logger logger = new Logger(AbstractLoggerHandler.ERROR);
        logger.setContent("错误消息");
        Logger logger1 = new Logger(AbstractLoggerHandler.INFO);
        logger1.setContent("普通消息");
        Logger logger2 = new Logger(AbstractLoggerHandler.DEBUG);
        logger2.setContent("调试消息");

        loggerHandler.print(logger);
        loggerHandler.print(logger1);
        loggerHandler.print(logger2);
    }
}
