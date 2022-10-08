package com.merce.woven.behavior.chain;

public class ErrorLoggerHandler extends AbstractLoggerHandler{
    public ErrorLoggerHandler(AbstractLoggerHandler nextHandler) {
        super(nextHandler);
        this.level = ERROR;
    }

    @Override
    protected void write(String content) {
        System.out.print("[ERROR]\t: ");
        System.out.println(content);
    }
}
