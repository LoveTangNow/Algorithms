package wha.basic;

import wha.sort.Sort;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.Stopwatch;

public class Task1 {
	public void fun0(){//整数溢出的实例（-2147483648是int类型的最小值）
		System.out.println(Math.abs(-2147483648));//result:-2147483648
	}
	/**
	 * 如何才能将一个double 变量初始化为无穷大？可以使用Java 的内置常数：
	 * Double.POSITIVE_INFINITY 和Double.NEGATIVE_INFINITY。
	 */
	public void fun1(){
		double pos = Double.POSITIVE_INFINITY;
		double neg = Double.NEGATIVE_INFINITY;
		System.out.println(pos);
		System.out.println(neg);
	}
	/**
	 * 1.0/0.0(1.0/0,1/0.0  int自动转化为double)的值是无穷大，1/0运行时报除0异常
	 */
	public void fun2(){
		System.out.println(1.0/0.0);//INFINITY
	}
	/**
	 * 负数的取余：a % b 的余数的定义是(a/b)*b + a % b 恒等于a。(余数与被余数的符号相同)
	 * 例如-14/3 和14/-3 的商都是-4，但-14 % 3 是-2，而14 % -3 是2。
	 */
	public void fun3(){
		System.out.println(-14%3);//-2
		System.out.println(14%-3);//2
	}
	public void fun4(){
		System.out.println(true && false || true && true);//true 从左到右
	}
	
	public void fun6(){}
	/**
	 * 求两个数的最大公约数 |欧几里得算法
	 * @param p
	 * @param q
	 * @return
	 */
	public static int gcd(int p,int q){
		if(q == 0)	return p;
		return gcd(q, p % q);
	}
	/**
	 * 斐波那契算法的性能比较
	 * @param N
	 */
	public static void FiboCompare(int N){
		long f1,f2,f3;
		for(int i = 0;i < 3; i++){
			Stopwatch timer = new Stopwatch();
			if(i==0){ f1 = One.Fibo_n(N);System.out.print(f1+" ");}//0.001
			if(i==1){ f2 = One.Fibo_c(10000);System.out.print(f2+" ");}//0.001
			if(i==2){ f3 = One.Fibo(N);System.out.print(f3+" ");}//75.257
			StdOut.println(timer.elapsedTime());
		}
	}
	/**
	 * 求两个输入数的最大公约数。
	 */
	public void Euclid(){
		StdOut.println("请输入两个正整数）：");
		if(!StdIn.isEmpty()){
			int p = StdIn.readInt();
			int q = StdIn.readInt();
			StdOut.print(gcd(p,q));
		}
	}
	
	
	public static void main(String[] args) {
		Task1 t = new Task1();
		//t.Euclid();
		FiboCompare(50);
	}
}
