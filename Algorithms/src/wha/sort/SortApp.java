package wha.sort;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.Stopwatch;

public class SortApp {
	/**
	 * v是否比w小
	 * @param v
	 * @param w
	 * @return
	 */
	public static boolean less(Comparable v,Comparable w){
		return v.compareTo(w) < 0;
	}
	/**
	 * 两个数交换
	 * @param a
	 * @param i
	 * @param j
	 */
	public static void exch(Comparable[] a,int i,int j){
		Comparable t = a[i];
		a[i] = a[j];
		a[j] = t;
	}
	/**
	 * 单行中打印数组
	 * @param a
	 */
	public static void show(Comparable[] a){
		for(int i = 0; i < a.length; i++)
			StdOut.print(a[i] + " ");
		StdOut.println();
	}
	/**
	 * 是否从小到大排好了序
	 * @param a
	 * @return
	 */
	public static boolean isSorted(Comparable[] a){
		for(int i = 1; i < a.length; i++)
			if(less(a[i],a[i-1]))	return false;
		return true;
	}
	
	
	
	public static void main(String[] args) {
		Comparable[] a = {1,45,67,123,78,3,6,89,2,3,3,34,24,65,889,23,43,66,23,77,45};
		Sort.bubble(a);
		show(a);
//		Comparable[] b = {"S","H", "E", "L", "L", "S", "O", "R", "T", "E", "X", "A", "M", "P", "L", "E"};
//		for(int i = 0; i < 16; i++)
//			StdOut.print(i%10+" ");
//		StdOut.println();
//		show(b);
//		Sort.shell(b);
//		show(b);
	}
}
