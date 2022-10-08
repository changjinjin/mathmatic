package com.merce.woven.behavior.chain;

public class Logger {

    /**
     * 日志级别
     */
    private int level;

    /**
     * 日志内容
     */
    private String content;

    public Logger(int level){
        this.level = level;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
