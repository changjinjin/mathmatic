package com.merce.study.sparsearray.test;

/**
 * @ClassName NSparseArray
 * @Deacription TODO
 * @Author Administrator
 * @Date 2020/9/25 18:00
 * @Version 1.0
 **/

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * 稀疏数组和二维数组的相互转换
 */
public class NSparseArray {

    private static int[][] originalArray;
    private static int[][] sparseArr;
    private static final String path = "map.md"; // 文件路径设置为项目路径下

    public static void main(String[] args) {
        int[][] sparseArr2 = original2Sparse(originalArray, sparseArr); //二维数组转稀疏数组
        saveSparse(sparseArr2); // 将稀疏数组保存到文件中
        int[][] sparseArr3 = readSparse(); // 读取文件中的稀疏数组
        Sparse2original(originalArray, sparseArr3); //稀疏数组转原始的二维数组
    }

    /**
     * 将二维数组转化为稀疏数组
     *
     * @param originalArray
     * @param sparseArr
     */
    public static int[][] original2Sparse(int[][] originalArray, int[][] sparseArr) {
        /*
          二维数组转稀疏数组的思路：
            1. 遍历原始的二维数组，得到有效数据的个数 sum
            2. 根据 sum 就可以创建稀疏数组 sparseArr int \[sum+1][3]
            3. 将二维数组的有效数据存入到稀疏数组
        */
        // 初始化原始数组
        originalArray = initOriginal(originalArray);
        // 打印原始数组
        System.out.println("这是原始二维数组：");
        for (int i = 0; i < originalArray.length; i++) {
            for (int j = 0; j < originalArray[i].length; j++) {
                System.out.printf("%d\t", originalArray[i][j]);
            }
            System.out.println();
        }

        // 1. 遍历原始的二维数组，得到有效数据的个数 sum
        int sum = 0;
        for (int i = 0; i < originalArray.length; i++) {
            for (int j = 0; j < originalArray[i].length; j++) {
                if (originalArray[i][j] != 0) {
                    sum++;
                }
            }
        }
        // 2. 根据 sum 就可以创建稀疏数组 sparseArr int[sum+1][3]
        sparseArr = new int[sum + 1][3];
        // 3. 将二维数组的有效数据存入到稀疏数组
        initSparse(originalArray, sparseArr, sum);
        System.out.println("这是存入有效数据后的稀疏数组：");
        // 遍历稀疏数组
        for (int i = 0; i < sparseArr.length; i++) {
            System.out.printf("%d\t%d\t%d\t\n", sparseArr[i][0], sparseArr[i][1], sparseArr[i][2]);
        }
        return sparseArr;
    }

    /**
     * 稀疏数组转化为二维数组
     *
     * @param originalArray
     * @param sparseArr
     */
    public static void Sparse2original(int[][] originalArray, int[][] sparseArr) {
        /*
          稀疏数组转原始的二维数组的思路：
            1. 先读取稀疏数组的第一行，根据第一行的数据，创建原始的二维数组，比如上面的 chessArr2 = int [11][11]
            2. 在读取稀疏数组后几行的数据，并赋给原始的二维数组即可。
        */
        // 1. 先读取稀疏数组的第一行，根据第一行的数据，创建原始的二维数组
        originalArray = new int[sparseArr[0][0]][sparseArr[0][1]];
        // 2. 在读取稀疏数组后几行的数据，并赋给原始的二维数组即可。
        for (int i = 1; i < sparseArr.length; i++) {
            originalArray[sparseArr[i][0]][sparseArr[i][1]] = sparseArr[i][2];
        }

        System.out.println("这是稀疏数组还原的原始数组：");
        // 遍历还原的数组
        for (int i = 0; i < originalArray.length; i++) {
            for (int j = 0; j < originalArray[i].length; j++) {
                System.out.printf("%d\t", originalArray[i][j]);
            }
            System.out.println();
        }
    }

    /**
     * 初始化原始数组
     *
     * @param originalArray
     */
    private static int[][] initOriginal(int[][] originalArray) {
        // 准备一个二维数组
        originalArray = new int[11][11];
        for (int i = 0; i < originalArray.length; i++) {
            for (int j = 0; j < originalArray[i].length; j++) {
                originalArray[i][j] = 0;
            }
        }
        originalArray[1][2] = 1;
        originalArray[2][3] = 2;

        return originalArray;
    }

    /**
     * 将二维数组有效数据存入稀疏数组
     *
     * @param originalArray
     * @param sparseArr
     */
    private static void initSparse(int[][] originalArray, int[][] sparseArr, int sum) {
        sparseArr[0][0] = originalArray.length;
        sparseArr[0][1] = originalArray[0].length;
        sparseArr[0][2] = sum;
        int count = 1;
        for (int i = 0; i < originalArray.length; i++) {
            for (int j = 0; j < originalArray[i].length; j++) {
                if (originalArray[i][j] != 0) {
                    sparseArr[count][0] = i;
                    sparseArr[count][1] = j;
                    sparseArr[count][2] = originalArray[i][j];
                    count++;
                }
            }
        }
    }

    /**
     * 将稀疏数组保存到文件中
     *
     * @param sparseArr
     */
    private static void saveSparse(int[][] sparseArr) {
        // 创建字符输出流
        FileWriter fileWriter = null;
        try {
            // 数据写入的路径文件
            File file = new File(path);
            // 文件不存在时新建
            if (!file.exists()) {
                file.createNewFile();
            }
            // 字符输出流赋予对象
            fileWriter = new FileWriter(file);
            // 将数组写入文件中
            for (int i = 0; i < sparseArr.length; i++) {
                // 前两列数据用 "," 隔开
                for (int j = 0; j < 2; j++) {
                    fileWriter.write(sparseArr[i][j] + ",");
                }
                // 最后一列不加 "," 而是换行
                fileWriter.write(sparseArr[i][2] + "\n");
            }
            // 把管道的数据全部刷出来
            fileWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                // fileWriter不为空时关闭资源
                if (fileWriter != null) {
                    fileWriter.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 从文件中读取出稀疏数组
     *
     * @return
     */
    private static int[][] readSparse() {
        // 声明文件字符输入流
        FileReader fileReader = null;
        // 声明字符输入缓冲流
        BufferedReader bufferedReader = null;
        // 声明二维数组用于存储读取的结果
        int[][] sparseArr = null;
        try {
            // 指定读取文件路径
            fileReader = new FileReader(new File(path));
            // 通过BufferedReader包装字符输入流
            bufferedReader = new BufferedReader(fileReader);
            // 创建集合用于存储读取的文件的一行一行的数据
            List<String> lineStrs = new ArrayList<>();
            // 存储读取到的一行数据
            String lineStr = null;

            // 一行一行遍历文件的数据
            while((lineStr = bufferedReader.readLine()) != null){
                // 将读取到的行添加到 List中
                lineStrs.add(lineStr);
            }

            // 创建数组
            sparseArr = new int[lineStrs.size()][3]; // 集合的大小，即为数组行数
            // 遍历集合，为数组赋值
            int count = 0;
            for(String str : lineStrs){
                String[] strs = str.split(",");
                sparseArr[count][0] = Integer.valueOf(strs[0]);
                sparseArr[count][1] = Integer.valueOf(strs[1]);
                sparseArr[count][2] = Integer.valueOf(strs[2]);
                count++;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 关闭字符输入流
            try {
                if(fileReader != null){
                    fileReader.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            // 关闭字符输入缓冲流
            try {
                if(bufferedReader != null){
                    bufferedReader.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return sparseArr;
    }
}