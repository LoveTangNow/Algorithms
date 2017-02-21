package wha.basic;

import edu.princeton.cs.algs4.In;
import org.junit.Test;
import wha.sort.SortApp;

import java.util.*;

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

    /**
     * 一个数组中，如果有元素的个数大于数组长度的一半，则返回这个个数，否则返回0
     */
    public int moreThanHalfNum(int [] array) {
        if(array==null || array.length==0) throw new RuntimeException("输入错误！");
        Map<Integer,Integer> map = new HashMap<>();
        int count = 0;
        int target = 0;
        for(int i=0; i<array.length; i++){
            if(map.containsKey(array[i])){
                map.put(array[i],map.get(array[i])+1);
                if(count < map.get(array[i])){
                    target = array[i];
                    count = map.get(array[i]);
                }
            }else{
                map.put(array[i],1);
            }
        }
        if(count > array.length/2){
            return target;
        }else{
            return 0;
        }
    }

    @Test
    public void moreThanHalfNumTest(){
        int[] arr = {1,2,3,2,2,2,5,4,2};
        int[] a = {1,2,5,7,8,2,12,4};
        System.out.println(moreThanHalfNum(arr));
    }


    /**
     *输入n个整数，找出其中最小的K个数。例如输入4,5,1,6,2,7,3,8这8个数字，
     * 则最小的4个数字是1,2,3,4,。
     */
    public ArrayList<Integer> GetLeastNumbers(int [] input, int k) {
        ArrayList<Integer> list =  new ArrayList<>();
        if(input.length ==0 || k<1 || k>input.length){
            return list;
        }
        int temp ;
        for(int i = 0;i<k;i++){
            for(int j=input.length-1; j>i;j--){
                if(input[j]<input[j-1]){
                    temp = input[j];
                    input[j] = input[j-1];
                    input[j-1] = temp;
                }
            }
            list.add(input[i]);
        }

        return list;
    }

    /**
     * 查找数组里连续元素的最大值。如{6,-3,-2,7,-15,1,2,2},
     * 连续子向量的最大和为8(从第0个开始,到第3个为止)。(子向量的长度至少是1)
     */
    public int findGreatestSumOfSubArray(int[] array) {
        //每一段连续元素的最大值，都是以正数开始（前面是非正数），
        if(array.length == 0)   return 0;
        int tmpSum = array[0],sum = array[0];
        for(int i=1; i<array.length; i++){
            tmpSum = tmpSum<0 ? array[i] : tmpSum+array[i];
            sum = sum>tmpSum ? sum :tmpSum;
        }

        return sum;
    }

    /**
     *1~n区间所有的数中，1出现的次数
     */
    public int numberOf1Between1AndN(int n) {
        String s = "",m;
        char c = '1';
        int count = 0;
        for(int i=1;i<=n;i++){
            m = s+i;
            for(int j=0;j<m.length();j++){
                if(m.charAt(j) == c)    count++;
            }
        }

        return count;
    }

    public int numberOf1Between1AndNII(int n) {
        int ones = 0;
        for (long m = 1; m <= n; m *= 10)
            ones += (n/m + 8) / 10 * m + (n/m % 10 == 1 ? n%m + 1 : 0);
        return ones;
    }


    /**
     * 输入一个正整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。
     * 例如输入数组{3，32，321}，则打印出这三个数字能排成的最小数字为321323
     * key:定义规则,
     * 若ab>ba,则a"大于"b
     * 若ab<ba,则a"小于"b
     * 若ab=ba,则a"等于"b
     */
    public String printMinNumber(int [] numbers) {
        if(numbers==null || numbers.length==0)  return "";

        StringBuilder number = new StringBuilder();
        ArrayList<Integer> list = new ArrayList<>();
        for (int i=0; i<numbers.length;i++){
            list.add(numbers[i]);
        }

        Collections.sort(list, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                String s1 = o1 + "" + o2;
                String s2 = o2 + "" + o1;
                return s1.compareTo(s2);//
            }
        });

        for (int i: list){
            number.append(i);
        }
        return number.toString();
    }

    /**
     * 在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。输入一个数组,
     * 求出这个数组中的逆序对的总数P。并将P对1000000007取模的结果输出。 即输出P%1000000007
     * 例子:1,2,3,4,5,6,7,0,输入7
     */
    private int count=0;
    public int inversePairs(int [] array) {
        int[] result = new int [array.length];
        mergeSortRecursive(array,result, 0,array.length-1);
        return count%1000000007;
    }


    private void mergeSortRecursive(int[] arr, int[] result, int start, int end) {
        if(start >= end)    return;
        int len = end -start,mid = start + (len>>1);
        int start1 = start,end1 = mid;
        int start2 = mid+1,end2 = end;
        mergeSortRecursive(arr, result, start1, end1);
        mergeSortRecursive(arr, result, start2, end2);
        int k=start;
        while (start1<=end1 && start2<=end2){
            if(arr[start1] <= arr[start2]){
                result[k++] = arr[start1++];
            } else{
                result[k++] = arr[start2++];
                count += (end1- start1 + 1);
                count = count%1000000007;
            }
        }

        while (start1 <=end1) {
            result[k++] = arr[start1++];
        }

        while (start2 <= end2) {
            result[k++] = arr[start2++];
        }

        for(k=start; k<=end; k++){
            arr[k] = result[k];
        }
    }

    @Test
    public void inversePairsTest(){
        int[] arr ={1,2,3,4,5,6,7,0};
        System.out.println(inversePairs(arr));
    }

    public int getNumberOfK(int [] array , int k) {
        if(array.length==0 || k<array[0] || k>array[array.length-1]){
            return 0;
        }

        int count = 0;
        for(int i=0;i<array.length;i++){
            if(array[i] == k){
                count++;
            }
        }

        return count;
    }

    /**
     * 一个整型数组里除了两个数字之外，其他的数字都出现了两次。请写程序找出这两个只出现一次的数字。
     */
    public void findNumsAppearOnce(int [] array,int num1[] , int num2[]) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<array.length;i++){
            if(map.containsKey(array[i])){
                map.remove(array[i]);
            }else map.put(array[i],array[i]);
        }
        int i=0;
        for(Map.Entry<Integer,Integer> en: map.entrySet()){
            if(i==0){
                num1[0] = en.getValue();
            }else {
                num2[0] = en.getValue();
            }
            i++;
        }
    }

    /**
     * 异或版: 两个相同的数异或结果为0
     * 1.第一次使用异或运算，得到了两个只出现一次的数相异或的结果。
      2.因为两个只出现一次的数肯定不同，即他们的异或结果一定不为0，一定有一个位上有1。
     另外一个此位上没有1，我们可以根据此位上是否有1，将整个数组重新划分成两部分，一部分此位上一定有1，
     另一部分此位上一定没有1，然后分别对每部分求异或，因为划分后的两部分有这样的特点：
     其他数都出现两次，只有一个数只出现一次。
     因此，我们又可以运用异或运算，分别得到两部分只出现一次的数。
     */
    public void findNumsAppearOnceII(int [] array,int num1[] , int num2[]) {
        int mix = 0 ,flag=1;
        for(int i=0; i<array.length; i++){
            mix ^= array[i];
        }
        while ((mix&flag)==0)   flag <<= 1;
        num1[0] = mix;num2[0] = mix;
        for(int i=0; i<array.length; i++){
            if((flag & array[i]) == 0) num1[0] ^= array[i];
            else num2[0] ^= array[i];
        }
    }

    /**
     *
     */
    public ArrayList<Integer> maxInWindows(int [] num, int size)
    {

        ArrayList<Integer> list = new ArrayList<>();
        if(size < 1)	return list;
        int length = num.length - size + 1;
        int max = Integer.MIN_VALUE;

        for(int i=0; i<length;i++){
            for(int j=0;j<size;j++){
                int tem = num[i+j];
                if(tem > max)   max = tem;
            }
            list.add(max);

        }
        return list;
    }
}
