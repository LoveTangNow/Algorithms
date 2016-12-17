package wha.basic;

import edu.princeton.cs.algs4.In;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by wwha on 16-12-13.
 */
public class ArrayApp {

    /**
     * 在一个二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
     * 请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
     * key: 从左下角开始比较：
     *  当target比他小时，向上移动；
     *  当target比他大时，向右移动；
     */
    public boolean find(int target, int [][] array) {
        int rowLen = array.length;
        if(rowLen == 0) return false;
        int collen = array[0].length;
        int i = rowLen-1,j=0;
        while (i>=0 && j<collen){
            if(target == array[i][j])   return true;
            else if(target < array[i][j])   i--;
            else j++;
        }
        return false;
    }

    /**
     * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有的奇数位于数组的前半部分，
     * 所有的偶数位于位于数组的后半部分，并保证奇数和奇数，偶数和偶数之间的相对位置不变。
     */
    public static int[] reOrderArray(int [] array) {
        int len = array.length;
        if(len == 0) return null;
        Queue<Integer> queue = new LinkedList<Integer>();
        int index = 0;
        for(int i=0; i<len; i++){
            if(array[i]%2==0){
                queue.offer(array[i]);
            }else{
                array[index++] = array[i];
            }
        }
        while (!queue.isEmpty()){
            array[index++] = queue.poll();
        }

        return array;
    }

    /**
     * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字
     */
    public ArrayList<Integer> printMatrix(int [][] matrix) {
        if(matrix== null)   return null;
        ArrayList<Integer> list = new ArrayList<Integer>();
        int row = matrix.length;
        int col = matrix[0].length;
        int i=0, left = 0,right=col -1,top=0,bottom=row -1;
        while(left <= right && top <= bottom){
            for(i = left;i<=right;i++){//上 左至右
                list.add(matrix[top][i]);
            }

            for (i=top + 1; i<= bottom ;i++){//右 上至下
                list.add(matrix[i][right]);
            }
            if(top!=bottom)
                for(i=right-1; i>=left;i--){
                    list.add(matrix[bottom][i]);
                }
            if(left != right){
                for(i=bottom -1; i>top; i--){
                    list.add(matrix[i][left]);
                }
            }
            left++; top++; right--; bottom--;
        }

        return list;
    }

    /**
     * 打印一个集合的所有子集
     * key：长度为n的集合的子集数为2^n，
     * 每一个元素都对应着选与不选两个选择，那么就用0~2^n的二进制数作为元素的选择。
     */

    public static void printSubCollections(String[] arr){

        if(arr== null || arr.length ==0) return;
        int len = arr.length;
        for(int i=0; i<(1<<len); i++){
            String setBin = Integer.toBinaryString(i);
            int un = len - setBin.length();
            System.out.print("{");
            for(int j=0;j<setBin.length(); j++){
                if(setBin.charAt(j)== '1'){
                    System.out.print(arr[un+j]);//例如{a,b,c},c对应001，bc对应11
                }
            }
            System.out.println("}");
        }
    }

    @Test
    public void printSubCollectionsTest(){
        String[] s = {"a","b","c","d"};
        printSubCollections(s);
    }

    @Test
    public void printMatrix(){
        int[][] m = {
                {1,2,3,4,5},
                {6,7,8,9,10},
                {11,12,13,14,15},
                {16,17,18,19,20},
                {21,22,23,24,25}
        };
        int[][] m1 = {{1,2,3,4,5}};
        int[][] m2 = {
                {1},{2},{3},{4},{5}
        };
        for(Integer i: printMatrix(m2)){
            System.out.print(i + ",");
        }
    }


    @Test
    public void reOrderArrayTest(){
        int[] arr = {1,3,2,6,3,4,2,7,8,3,7,12,5,3};
        reOrderArray(arr);
        for(int i=0; i<arr.length;i++){
            System.out.print(arr[i] + ",");
        }
    }


}
