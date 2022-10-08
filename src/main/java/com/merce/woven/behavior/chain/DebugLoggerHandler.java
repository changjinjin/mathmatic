package com.merce.woven.behavior.chain;

public class DebugLoggerHandler extends AbstractLoggerHandler {
    public DebugLoggerHandler(AbstractLoggerHandler nextHandler) {
        super(nextHandler);
        this.level = DEBUG;
    }

    @Override
    protected void write(String content) {
        System.out.print("[DEBUG]\t: ");
        System.out.println(content);
    }
}
