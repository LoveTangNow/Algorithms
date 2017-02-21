package wha.basic;


import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by wwha on 16-12-12.
 */
public class MathApp {
    /**
     * f(0)=0,f(1)=1,f(i)=0,1,1,2,3,5..
     * f(n) = f(n-1) + f(n-2);
     */
    public static int Fibonacci(int n) {
        if (n == 0) return 0;
        else if (n == 1) return 1;
        int i = 2;
        int fn_2 = 0, fn_1 = 1, m = 0;
        while (i++ <= n) {
            m = fn_1 + fn_2;
            fn_2 = fn_1;
            fn_1 = m;
        }
        return m;
    }

    /**
     * 一只青蛙一次可以跳上1级台阶，也可以跳上2级。求该青蛙跳上一个n级的台阶总共有多少种跳法。
     * a.如果两种跳法，1阶或者2阶，那么假定第一次跳的是一阶，那么剩下的是n-1个台阶，跳法是f(n-1);
     * b.假定第一次跳的是2阶，那么剩下的是n-2个台阶，跳法是f(n-2)
     * c.由a\b假设可以得出总跳法为: f(n) = f(n-1) + f(n-2)
     * d.然后通过实际的情况可以得出：只有一阶的时候 f(1) = 1 ,只有两阶的时候可以有 f(2) = 2
     */

    public static int JumpFloor(int target) {
        if (target == 0) return 0;
        else if (target == 1) return 1;
        else if (target == 2) return 2;
        int i = 3;
        int fn_2 = 1, fn_1 = 2, m = 0;
        while (i++ <= target) {
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
        if (target == 0) return 0;
        else if (target == 1) return 1;
        else if (target == 2) return 2;
        int i = 3;
        int last = 1 + 2, n = 0;
        while (i++ <= n) {
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
        if (target == 1) return 1;
        else if (target == 2) return 2;
        int fn_2 = 1, fn_1 = 2, m = 0;
        int i = 3;
        while (i++ <= target) {
            m = fn_1 + fn_2;
            fn_2 = fn_1;
            fn_1 = m;
        }
        return m;
    }

    /**
     * 把只包含因子2、3和5的数称作丑数（Ugly Number）。例如6、8都是丑数，但14不是，因为它包含因子7。
     * 习惯上我们把1当做是第一个丑数。求按从小到大的顺序的第N个丑数。
     */
    public int getUglyNumber(int index) {
        int m = 0, count = 0;
        for (int i = 1; ; i++) {
            m = i;
            while (m % 2 == 0 || m % 3 == 0 || m % 5 == 0) {
                m = m % 2 == 0 ? m / 2 : m;
                m = m % 3 == 0 ? m / 3 : m;
                m = m % 5 == 0 ? m / 5 : m;
            }
            if (m == 1) {
                if (++count == index) {
                    return i;
                }
            }
        }

    }

    public int getUglyNumberII(int index) {
        if (index < 7) return index;
        int[] arr = new int[index];
        arr[0] = 1;
        int t2 = 0, t3 = 0, t5 = 0;

        for (int i = 1; i < index; i++) {
            arr[i] = min(arr[t2] * 2, min(arr[t3] * 3, arr[t5] * 5));
            if (arr[i] == arr[t2] * 2) {
                t2++;
            }
            if (arr[i] == arr[t3] * 3) {
                t3++;
            }
            if (arr[i] == arr[t5] * 5) {
                t5++;
            }
        }
        return arr[index - 1];
    }

    public int min(int a, int b) {
        return a > b ? b : a;
    }

    @Test
    public void getUglyNumberTest() {
        System.out.println(getUglyNumber(1200));
    }


    /**
     * 输入一个递增排序的数组和一个数字S，在数组中查找两个数，是的他们的和正好是S，
     * 如果有多对数字的和等于S，输出两个数的乘积最小的
     */
    public ArrayList<Integer> findNumbersWithSum(int[] array, int sum) {
        ArrayList<Integer> list = new ArrayList<>();
        if (array.length < 2) return list;

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] + array[j] == sum) {
                    map.put(array[i], array[j]);
                } else if (array[i] + array[j] > sum) {
                    break;
                }
            }
        }

        int min = Integer.MAX_VALUE, a = 0, b = 0;
        boolean isExisted = false;
        for (Map.Entry<Integer, Integer> en : map.entrySet()) {
            if (en.getKey() * en.getValue() < min) {
                min = en.getKey() * en.getValue();
                a = en.getKey();
                b = en.getValue();
                isExisted = true;
            }
        }


        if (isExisted) {
            list.add(a);
            list.add(b);
        }
        return list;
    }

    /**
     * 输出所有和为S的连续正数序列。序列内按照从小至大的顺序，序列间按照开始数字从小到大的顺序
     * TODO
     */
    public ArrayList<ArrayList<Integer>> findContinuousSequence(int sum) {

        return null;
    }

    /**
     * 判断5张牌是不是顺子 注意:一共4张大小王,可以当任意牌,数组中表示为0,A只表示1
     * Key:没有重复值
     * max-min <5
     */

    public boolean isContinuous(int[] numbers) {
        if (numbers.length != 5) return false;
        int max = -1, min = 14;
        int flag = 0, num, count0 = 0;
        for (int i = 0; i < numbers.length; i++) {
            num = numbers[i];
            if (num < 0 || num > 13) return false;

            if (num == 0) {
                if (++count0 <= 4) {
                    continue;
                } else return false;
            }

            if (((flag >> num) & 1) == 1) return false;//判断是否有相同的数
            flag |= (1 << num);
            if (min > num) min = num;
            if (max < num) max = num;
            if ((max - min) >= 5) return false;
        }

        return true;

    }

    @Test
    public void isContinuousTest() {
        int[] a = {0, 0, 1, 2, 3};
        int[] b = {0, 4, 1, 2, 3};
        int[] c = {0, 0, 0, 0, 3};
        int[] d = {0, 0, 0, 0, 0};
        int[] e = {1, 6, 0, 0, 0};

        System.out.println(isContinuous(e));
    }


    public int lastRemaining(int n, int m) {
        if (n < 1 || m < 1) return -1;

        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            list.add(i);
        }
        int k = 0;
        while (list.size() != 1) {
            k = (k + (m - 1)) % list.size();//k表示上次删除list中的元素索引
            System.out.println(list.get(k));
            list.remove(k);
        }

        return list.get(0);
    }


    @Test
    public void lastRemainingTest() {
        lastRemaining(11, 7);
    }

    /**
     * 求1+2+3+...+n的值,不用循环和判断语句
     */
    public int Sum_Solution(int n) {
        int sum = n;
        boolean b = (n > 0) && ((sum += Sum_Solution(n - 1)) > 0);
        return sum;
    }

    /**
     * 写一个函数，求两个整数之和，要求在函数体内不得使用+、-、*、/四则运算符号
     * 5-101，7-111
     * 第一步：相加各位的值，不算进位，得到010，二进制每位相加就相当于各位做异或操作，101^111。
     * 第二步：计算进位值，得到1010，相当于各位做与操作得到101，再向左移一位得到1010，(101&111)<<1。
     * 第三步重复上述两步， 各位相加 010^1010=1000，进位值为100=(010&1010)<<1。
     * 继续重复上述两步：1000^100 = 1100，进位值为0，跳出循环，1100为最终结果。
     */

    public int add(int num1, int num2) {
        int temp;
        while (num2 != 0) {
            temp = num1 ^ num2;
            num2 = (num1 & num2) << 1;
            num1 = temp;
        }
        return num1;
    }

    @Test
    public void addTest() {
        int a = 1, b = 2;
        System.out.println(add(a, b));
    }

    /**
     * 请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。
     * 路径可以从矩阵中的任意一个格子开始，每一步可以在矩阵中向左，向右，向上，向下移动一个格子。
     * 如果一条路径经过了矩阵中的某一个格子，则该路径不能再进入该格子。 例如[a b c e s f c s a d e e]是3*4矩阵，
     * 其包含字符串"bcced"的路径，但是矩阵中不包含“abcb”路径，
     * 因为字符串的第一个字符b占据了矩阵中的第一行第二个格子之后，路径不能再次进入该格子。
     * flag存储的是已经走过的路径；
     */
    public boolean hasPath(char[] matrix, int rows, int cols, char[] str) {
        int matLen = matrix.length;
        int strLen = str.length;
        if (matLen != rows * cols || strLen > matLen) return false;
        int[] flag = new int[matLen];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (goAhead(matrix, str, rows, cols, i, j, 0, flag)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean goAhead(char[] matrix, char[] str, int rows, int cols, int i, int j, int index, int[] flag) {
        int k = i * cols + j;
        if (i < 0 || i >=rows || j < 0 || j >=cols) return false;
        if (matrix[k] != str[index] || flag[k] == 1) {
            return false;
        }

        if (index + 1 == str.length) return true;
        flag[k] = 1;
        if (goAhead(matrix, str, rows, cols, i - 1, j, index + 1, flag) ||
                goAhead(matrix, str, rows, cols, i + 1, j, index + 1, flag) ||
                goAhead(matrix, str, rows, cols, i, j - 1, index + 1, flag) ||
                goAhead(matrix, str, rows, cols, i, j + 1, index + 1, flag)
                ) {
            return true;
        }
        flag[k] = 0;
        return false;
    }

    @Test
    public void hasPathTest() {
        String c = "abcesfcsadee";
        String s = "bcced";
        boolean b= hasPath(c.toCharArray(), 3,4,s.toCharArray());
        System.out.println(b);
    }
}
