package com.merce.woven.behavior.chain;

public class InfoLoggerHandler extends AbstractLoggerHandler{
    public InfoLoggerHandler(AbstractLoggerHandler nextHandler) {
        super(nextHandler);
        this.level = INFO;
    }

    @Override
    protected void write(String content) {
        System.out.print("[INFO]\t: ");
        System.out.println(content);
    }
}
