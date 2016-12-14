package wha.basic;

/**
 * Created by wwha on 16-12-13.
 */
public class StringApp {

    public static String replaceSpace(StringBuffer str) {
        String sti = str.toString();
        char[] strChar = sti.toCharArray();
        StringBuffer stb = new StringBuffer();
        for(int i=0;i<strChar.length;i++){
            if(strChar[i]==' '){
                stb.append("%20");
            }else{
                stb.append(strChar[i]);
            }
        }
        return stb.toString();
    }


    /**
     * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
     输入一个非递减排序的数组的一个旋转，输出旋转数组的最小元素。
     例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。
     NOTE：给出的所有元素都大于0，若数组大小为0，请返回0
     */
    public static int minNumberInRotateArray(int [] array) {
        if(array.length == 0)
            return 0;
        for(int i= array.length-1; i>1; i--){
            if(array[i]<array[i-1])
                return array[i];
        }
        return array[0];
    }



    public static void main(String[] args){
        StringBuffer sf = new StringBuffer("We Are Happy");
        System.out.println(replaceSpace(sf));
    }
}
