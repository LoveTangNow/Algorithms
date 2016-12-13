package wha.basic;

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
}
