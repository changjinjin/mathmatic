package com.merce.woven.behavior.chain;

/**
 * 抽象处理类
 *
 * @author ZhengNC
 * @date 2020/7/22 9:39
 */
public abstract class AbstractLoggerHandler {

    public static final int ERROR = 1;
    public static final int INFO = 2;
    public static final int DEBUG = 3;

    /**
     * 要处理的日志级别
     */
    protected int level;

    /**
     * 下一个日志处理类
     */
    private AbstractLoggerHandler nextHandler;

    public AbstractLoggerHandler(AbstractLoggerHandler nextHandler){
        this.nextHandler = nextHandler;
    }

    public void print(Logger logger){
        if (logger != null){
            if (logger.getLevel() == level){
                write(logger.getContent());
            }
        }
        if (nextHandler != null){
            nextHandler.print(logger);
        }
    }

    /**
     * 写出日志
     *
     * @param content
     */
    abstract protected void write(String content);
}
