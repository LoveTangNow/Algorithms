package wha.sort;

import org.junit.Test;

/**
 * Created by wwha on 16-11-7.
 */
public class SortApp {
    /**
     * 插入排序
     */
    public static int[] insertSort(int[] a){
        for(int i= 1; i<a.length; i++){
            if(a[i] < a[i-1]){               //若第i个元素大于i-1元素，直接插入。小于的话，移动有序表后插入
                int j= i-1;
                int x = a[i];        //复制为哨兵，即存储待排序元素
                while(j >= 0 && x < a[j]){  //查找在有序表的插入位置
                    a[j+1] = a[j];
                    j--;         //元素后移
                }
                a[j+1] = x;      //插入到正确位置
            }
        }
        return a;
    }

    /**
     * 冒泡排序
     * 它重复地走访过要排序的数列，一次比较两个元素，如果他们的顺序错误就把他们交换过来。
     * 走访数列的工作是重复地进行直到没有再需要交换，也就是说该数列已经排序完成
     */
    public static int[] bubSort(int[] a) {
        for(int i=0; i<a.length; i++){
            for(int j=0; j<a.length -i-1 ; j++){
                if(a[j] > a[j+1]){
                    int temp  = a[j];
                    a[j] = a[j+1];
                    a[j+1] = temp;
                }
            }
        }
        return a;
    }

    /**
     * 选择排序
     *首先在未排序序列中找到最小（大）元素，存放到排序序列的起始位置，然后，再从剩余未排序元素中继续寻找最小（大）元素，
     * 然后放到已排序序列的末尾。以此类推，直到所有元素均排序完毕。
     */
    public static int[] selectSort(int[] a){
        for(int i=0; i<a.length; i++){
            int min = i;
            for(int j=i+1; j<a.length; j++){
                if(a[min] > a[j]){
                    min = j;
                }
            }
            int temp = a[min];
            a[min]  = a[i];
            a[i] = temp;
        }

        return a;
    }

    /**
     *快排 挖坑填坑 + 分治
     * i,j 表示数组开始和结尾的索引
     */

    public static void quickSort(int[] s,int l,int r){
        if (l < r)
        {
            //Swap(s[l], s[(l + r) / 2]); //将中间的这个数和第一个数交换 参见注1
            int i = l, j = r, x = s[l];
            while (i < j)
            {
                while(i < j && s[j] >= x) // 从右向左找第一个小于x的数
                    j--;
                if(i < j)
                    s[i++] = s[j];

                while(i < j && s[i] < x) // 从左向右找第一个大于等于x的数
                    i++;
                if(i < j)
                    s[j--] = s[i];
            }
            s[i] = x;
            quickSort(s, l, i - 1); // 递归调用
            quickSort(s, i + 1, r);
        }

    }

    /**
     * 归并排序 递归版
     *
     */
    public static void mergeSort(int[] arr){
        int len = arr.length;
        int[] result = new int[len];
        mergeSortRecursive(arr,result,0,len-1);

    }

    private static void mergeSortRecursive(int[] arr, int[] result, int start, int end) {
        if(start >= end)    return;
        int len = end -start,mid = start + (len>>1);
        int start1 = start,end1 = mid;
        int start2 = mid+1,end2 = end;
        mergeSortRecursive(arr, result, start1, end1);
        mergeSortRecursive(arr, result, start2, end2);
        int k=start;
        while (start1<=end1 && start2<=end2){
            result[k++] = arr[start1]<arr[start2] ? arr[start1++] : arr[start2++];
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
    public void mergeSortTest(){
        int[] arr = {1,23,5,67,3,2,8,34,12,45,62,12,31,61,38,49,23,234,56,29,24,45,4,1,24};
        mergeSort(arr);
        print(arr);
    }


    public static void print(int[] a){
        for(int i=0; i<a.length; i++)
            System.out.println(a[i]);
    }

    public static void main(String[] args){
        int[] s = {1,5,8,12,3,4,5,0,24,7,2};
        int[] a = {1,2,3,2,2,2,5,4,2};
        quickSort(a,0,a.length-1);
        print(a);
    }
}
