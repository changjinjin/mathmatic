package com.merce.Algorithm.src.com.atguigu.dac;

/**
 * @ClassName Hanoitower
 * @Deacription 分治算法（汉诺塔）
 * @Author Administrator
 * @Date 2020/12/29 19:39
 * @Version 1.0
 **/
public class Hanoitower {
    private static int n = 0;
    public static void main(String[] args) {
        hanoiTower(10, 'A', 'B', 'C');
        hanoiTower_new(20, 'a', 'b', 'c');
    }

    private static void hanoiTower_new(int num, char a, char b, char c) {
        if(num == 1){
            System.out.println("第1个盘从 " + a + "->" + c);
        }else{
            hanoiTower_new(num - 1, a, c, b);
            System.out.println("第" + num + "个盘从 " + a + "->" + c);
            hanoiTower(num - 1, b, a, c);
        }
    }

    //汉诺塔的移动的方法
    //使用分治算法

    public static void hanoiTower(int num, char a, char b, char c) {
        //如果只有一个盘
        if(num == 1) {
            System.out.println("第1个盘从 " + a + "->" + c);
        } else {
            //如果我们有 n >= 2 情况，我们总是可以看做是两个盘 1.最下边的一个盘 2. 上面的所有盘
            //1. 先把 最上面的所有盘 A->B， 移动过程会使用到 c
            hanoiTower(num - 1, a, c, b);
            //2. 把最下边的盘 A->C
            System.out.println("第" + num + "个盘从 " + a + "->" + c);
            //3. 把B塔的所有盘 从 B->C , 移动过程使用到 a塔
            hanoiTower(num - 1, b, a, c);
        }
    }
}
