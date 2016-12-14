package wha.basic;

import edu.princeton.cs.algs4.In;
import org.junit.Test;

import java.util.ArrayList;
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

    @Test
    public void reOrderArrayTest(){
        int[] arr = {1,3,2,6,3,4,2,7,8,3,7,12,5,3};
        reOrderArray(arr);
        for(int i=0; i<arr.length;i++){
            System.out.print(arr[i] + ",");
        }
    }


}
