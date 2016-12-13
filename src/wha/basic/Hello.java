package wha.basic;

import java.io.Console;
import java.util.Scanner;

/**
 * Created by wwha on 16-12-12.
 */
public class Hello {
    public static void main(String[] args){
        System.out.println("hello");
        String prompt = "请输入一个数字：";
        String num = readString(prompt);
        System.out.println(num);

    }

    private static String readString(String prompt) {

        Scanner scanner = new Scanner(System.in);
        System.out.println(prompt);
        String read = scanner.nextLine();

        return read;

    }
}
