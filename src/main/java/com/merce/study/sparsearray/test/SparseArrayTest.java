package com.merce.study.sparsearray.test;

/**
 * @ClassName SparseArrayTest
 * @Deacription TODO
 * @Author Administrator
 * @Date 2020/9/25 17:59
 * @Version 1.0
 **/

/**
 * 稀疏数组和二维数组的相互转换
 */
public class SparseArrayTest {
    // 定义原始数组和稀疏数组
    private static int[][] originalArray;
    private static int[][] sparseArr;

    public static void main(String[] args) {
        // 原始数组转稀疏数组
        int[][] sparseArr2 = original2Sparse(originalArray, sparseArr);
        // 稀疏数组转原始数组
        Sparse2original(originalArray, sparseArr2);
    }

    /**
     * 将二维数组转化为稀疏数组方法
     * @param originalArray
     * @param sparseArr
     */
    public static int[][] original2Sparse(int[][] originalArray, int[][] sparseArr){
        /*
          二维数组转稀疏数组的思路：
            1. 遍历原始的二维数组，得到有效数据的个数 sum
            2. 根据 sum 就可以创建稀疏数组 sparseArr int[sum+1][3]
            3. 将二维数组的有效数据存入到稀疏数组
        */
        // 初始化原始数组
        originalArray = initOriginal(originalArray);
        // 打印原始数组
        System.out.println("这是原始二维数组：");
        for(int i = 0; i < originalArray.length; i++){
            for(int j = 0; j < originalArray[i].length; j++){
                System.out.printf("%d\t", originalArray[i][j]);
            }
            System.out.println();
        }

        // 1. 遍历原始的二维数组，得到有效数据的个数 sum
        int sum = 0;
        for(int i = 0; i < originalArray.length; i++){
            for(int j = 0; j < originalArray[i].length; j++){
                if(originalArray[i][j] != 0){
                    sum++;
                }
            }
        }
        // 2. 根据 sum 就可以创建稀疏数组 sparseArr int[sum+1][3]
        sparseArr = new int[sum+1][3];
        // 3. 将二维数组的有效数据存入到稀疏数组
        initSparse(originalArray, sparseArr, sum);
        System.out.println("这是存入有效数据后的稀疏数组：");
        // 遍历稀疏数组
        for(int i = 0; i < sparseArr.length; i++){
            System.out.printf("%d\t%d\t%d\t\n", sparseArr[i][0], sparseArr[i][1], sparseArr[i][2]);
        }

        return sparseArr;
    }

    /**
     * 稀疏数组转化为二维数组方法
     * @param originalArray
     * @param sparseArr
     */
    public static void Sparse2original(int[][] originalArray, int[][] sparseArr) {
        /*
          稀疏数组转原始的二维数组的思路：
            1. 先读取稀疏数组的第一行，根据第一行的数据，创建原始的二维数组，比如上面的 chessArr2 = int[11][11]
            2. 在读取稀疏数组后几行的数据，并赋给原始的二维数组
        */
        // 1. 先读取稀疏数组的第一行，根据第一行的数据，创建原始的二维数组
        originalArray = new int[sparseArr[0][0]][sparseArr[0][1]];
        // 2. 在读取稀疏数组后几行的数据，并赋给原始的二维数组即可。
        for(int i = 1; i < sparseArr.length; i++){
            originalArray[sparseArr[i][0]][sparseArr[i][1]] = sparseArr[i][2];
        }
        System.out.println("这是稀疏数组还原的原始数组：");
        // 遍历还原的数组
        for(int i = 0; i < originalArray.length; i++){
            for(int j = 0; j < originalArray[i].length; j++){
                System.out.printf("%d\t", originalArray[i][j]);
            }
            System.out.println();
        }
    }

    /**
     * 初始化原始数组
     * @param originalArray
     */
    private static int[][] initOriginal(int[][] originalArray) {
        // 准备一个二维数组
        originalArray = new int[11][11];
        for(int i = 0; i < originalArray.length; i++){
            for(int j = 0; j < originalArray[i].length; j++){
                originalArray[i][j] = 0;
            }
        }
        originalArray[1][2] = 1;
        originalArray[2][3] = 2;
        return originalArray;
    }

    /**
     * 将二维数组有效数据存入稀疏数组方法
     * @param originalArray
     * @param sparseArr
     */
    private static void initSparse(int[][] originalArray, int[][] sparseArr, int sum) {
        sparseArr[0][0] = originalArray.length;
        sparseArr[0][1] = originalArray[0].length;
        sparseArr[0][2] = sum;
        int count = 1;
        for(int i = 0; i < originalArray.length; i++){
            for(int j = 0; j < originalArray[i].length; j++){
                if(originalArray[i][j] != 0){
                    sparseArr[count][0] = i;
                    sparseArr[count][1] = j;
                    sparseArr[count][2] = originalArray[i][j];
                    count++;
                }
            }
        }
    }
}