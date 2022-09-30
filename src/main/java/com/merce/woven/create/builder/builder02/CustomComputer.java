package com.merce.woven.create.builder.builder02;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * 计算机
 *
 * @author ZhengNC
 * @date 2020/7/20 22:04
 */
@Getter
@Setter
@ToString
//计算机类及建造者类（计算机类的内部静态类）
public class CustomComputer {

    /**
     * cpu(必要)
     */
    private String cpu;

    /**
     * 主板(必要)
     */
    private String board;

    /**
     * 内存(必要)
     */
    private String ram;

    public CustomComputer(){}

    private CustomComputer(Builder builder){
        this.cpu = builder.cpu;
        this.board = builder.board;
        this.ram = builder.ram;
    }

    public static Builder builder(){
        return new Builder();
    }

    public static class Builder{
        private String cpu;
        private String board;
        private String ram;

        private Builder(){}

        /**
         * 设置CPU
         * @param cpu
         * @return
         */
        public Builder cpu(String cpu){
            this.cpu = cpu;
            return this;
        }

        /**
         * 设置主板
         * @param board
         * @return
         */
        public Builder board(String board){
            this.board = board;
            return this;
        }

        /**
         * 设置内存
         * @param ram
         * @return
         */
        public Builder ram(String ram){
            this.ram = ram;
            return this;
        }

        /**
         * 组装电脑
         * @return
         */
        public CustomComputer build(){
            return new CustomComputer(this);
        }
    }
}
