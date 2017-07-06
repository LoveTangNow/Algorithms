package wha.basic;

/**
 * Created by wwha on 17-7-5.
 */
public class Parent {
    String name;
    int value;

    public Parent(){}
    public Parent(String name){
        this.name = name;
    }
    public Parent(String name, int value){
        this(name);
        this.value = value;
    }
    public int a(int a, double b){ return 0;}
    public int a(double a,int b){return 0;}
    private static final String MESSAGE="taobao";
    public static void main(String [] args) {
        String a ="tao"+"bao";
        String b="tao";
        String c="bao";
        System.out.println(a==MESSAGE);
        System.out.println((b+c)==MESSAGE);
        Parent parent = new Parent();
        parent.a(1, 1.0);
    }
}
