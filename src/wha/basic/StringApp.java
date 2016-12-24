package wha.basic;

import org.junit.Test;

import java.util.*;

/**
 * Created by wwha on 16-12-13.
 */
public class StringApp {

    public static String replaceSpace(StringBuffer str) {
        String sti = str.toString();
        char[] strChar = sti.toCharArray();
        StringBuffer stb = new StringBuffer();
        for (int i = 0; i < strChar.length; i++) {
            if (strChar[i] == ' ') {
                stb.append("%20");
            } else {
                stb.append(strChar[i]);
            }
        }
        return stb.toString();
    }


    /**
     * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
     * 输入一个非递减排序的数组的一个旋转，输出旋转数组的最小元素。
     * 例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。
     * NOTE：给出的所有元素都大于0，若数组大小为0，请返回0
     */
    public static int minNumberInRotateArray(int[] array) {
        if (array.length == 0)
            return 0;
        for (int i = array.length - 1; i > 1; i--) {
            if (array[i] < array[i - 1])
                return array[i];
        }
        return array[0];
    }

    /**
     * 输入一个字符串,按字典序打印出该字符串中字符(可能会有重复)的所有排列。
     * 例如输入字符串abc,则打印出由字符a,b,c所能排列出来的所有字符串abc,acb,bac,bca,cab和cba。
     */

    public ArrayList<String> Permutation(String str) {
        if (str == null) return null;
        int len = str.length();
        ArrayList<String> arr = new ArrayList<>();
        int i = 0;
        while (i < len) {
            char fir = str.charAt(i);
            String restStr = str.substring(0, i) + str.substring(i + 1);

        }

        return arr;

    }

    /**
     *在一个字符串(1<=字符串长度<=10000，全部由大写字母组成)中找到第一个只出现一次的字符,并返回它的位置
     * key:用字符串中的每一个字符的ASCII码作为数组的索引,记录该字符出现的次数
     */
    public int firstNotRepeatingChar(String str) {
        if(str == null || str.length()==0)  return -1;
        int[] arr = new int['z'+1];
        for(int i=0; i<str.length(); i++){
            arr[str.charAt(i)]++;
        }

        for(int i=0; i<str.length(); i++){
            if(arr[str.charAt(i)]==1){
                return i;
            }
        }

        return -1;

    }

    @Test
    public void firstNotRepeatingCharTest() {
        System.out.println(firstNotRepeatingChar("akkjfalsdfjkldfasdkjlfjkhdfjhgasdfhacbcasdbhjasbdjhfabjsdfaskdfasijsdfaksefhaldsnfvasef"));
    }
}
