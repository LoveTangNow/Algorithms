package wha.basic;


import org.junit.Test;

/**
 * Created by wwha on 16-12-12.
 */
public class MathApp {
    /**
     *f(0)=0,f(1)=1,f(i)=0,1,1,2,3,5..
     * f(n) = f(n-1) + f(n-2);
     */
    public static int Fibonacci(int n) {
        if(n==0) return 0;
        else if(n==1) return 1;
        int i=2;
        int fn_2=0,fn_1=1,m=0;
        while(i++<=n){
            m = fn_1 + fn_2;
            fn_2 = fn_1;
            fn_1 = m;
        }
        return m;
    }

    /**
     * 一只青蛙一次可以跳上1级台阶，也可以跳上2级。求该青蛙跳上一个n级的台阶总共有多少种跳法。
     *a.如果两种跳法，1阶或者2阶，那么假定第一次跳的是一阶，那么剩下的是n-1个台阶，跳法是f(n-1);
     b.假定第一次跳的是2阶，那么剩下的是n-2个台阶，跳法是f(n-2)
     c.由a\b假设可以得出总跳法为: f(n) = f(n-1) + f(n-2)
     d.然后通过实际的情况可以得出：只有一阶的时候 f(1) = 1 ,只有两阶的时候可以有 f(2) = 2
     */

    public static int JumpFloor(int target) {
        if(target==0) return 0;
        else if(target==1) return 1;
        else if(target ==2) return 2;
        int i=3;
        int fn_2=1,fn_1=2,m=0;
        while(i++<=target){
            m = fn_1 + fn_2;
            fn_2 = fn_1;
            fn_1 = m;
        }
        return m;
    }


    /**
     * 一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。
     * 求该青蛙跳上一个n级的台阶总共有多少种跳法。
     * key:有n个台阶
     * 跳1阶时，那么剩下的是n-1个台阶，跳法是f(n-1);
     * 跳2阶时，那么剩下的是n-2个台阶，跳法是f(n-2);
     * 跳3阶时，那么剩下的是n-3个台阶，跳法是f(n-3);
     * 跳n阶时，跳法只有一种。
     * f(n) = f(1)+f(2)+....+f(n-1)+1;
     * 最简洁的答案：
     * 由于f(1)=1,f(2)=2,所以f(n) = 2^(n-1);
     * 一行代码：1<<(n-1);
     */

    public static int JumpFloorII(int target) {
        if(target==0) return 0;
        else if(target==1) return 1;
        else if(target ==2) return 2;
        int i=3;
        int last=1+2,n=0;
        while(i++<=n){
            n = last + 1;
            last += n;
        }
        return n;
    }


    /**
     * 我们可以用2*1的小矩形横着或者竖着去覆盖更大的矩形。
     * 请问用n个2*1的小矩形无重叠地覆盖一个2*n的大矩形，总共有多少种方法？
     * Key:依然是斐波那契数列。
     * 当n=1, 1种方法
     * 当n=2, 2种方法
     * 当n>=3, 第一块横着放，则还剩n-1个位置,有f(n-1)中方法
     * 当第一块竖着放时，还剩n-2个位置，有f(n-2)种方法
     */
    public static int rectCover(int target) {
        if(target==1)    return 1;
        else if(target == 2) return 2;
        int fn_2 =1, fn_1 = 2,m=0;
        int i=3;
        while(i++<=target){
            m = fn_1 + fn_2;
            fn_2 = fn_1;
            fn_1 = m;
        }
        return m;
    }

    /**
     *把只包含因子2、3和5的数称作丑数（Ugly Number）。例如6、8都是丑数，但14不是，因为它包含因子7。
     *  习惯上我们把1当做是第一个丑数。求按从小到大的顺序的第N个丑数。
     */
    public int getUglyNumber(int index) {
        int m = 0,count=0;
        for(int i=1;;i++){
            m = i;
            while (m%2==0 ||m%3==0 || m%5==0){
                m = m%2==0 ? m/2 : m;
                m = m%3==0 ? m/3 : m;
                m = m%5==0 ? m/5 : m;
            }
            if(m==1){
                if(++count == index){
                    return i;
                }
            }
        }

    }

    public int getUglyNumberII(int index) {
        if(index<7) return index;
        int[] arr = new int[index];
        arr[0] = 1;
        int t2=0,t3=0,t5=0;

        for(int i=1; i<index;i++){
            arr[i] = min(arr[t2]*2,min(arr[t3]*3, arr[t5]*5));
            if(arr[i]==arr[t2]*2){    t2++;   }
            if(arr[i]==arr[t3]*3){    t3++;   }
            if(arr[i]==arr[t5]*5){    t5++;   }
        }
        return arr[index-1];
    }

    public int min(int a, int b){
        return a>b?b:a;
    }
    @Test
    public void getUglyNumberTest(){
        System.out.println(getUglyNumber(1200));
    }

}
