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

    public static void main(String[] args){
        StringBuffer sf = new StringBuffer("We Are Happy");
        System.out.println(replaceSpace(sf));
    }
}
