package wha.basic;


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


    public static void main(String[] args){

    }
}
