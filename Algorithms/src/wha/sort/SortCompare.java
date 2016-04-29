package wha.sort;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.Stopwatch;

public class SortCompare {
	/**
	 * 获取排序算法的执行时间
	 * @param alg
	 * @param a
	 * @return
	 */
	public static double time(String alg, Comparable[] a){
		Stopwatch timer = new Stopwatch();
		if (alg.equals("Insertion")) Sort.insert(a);
		if (alg.equals("Selection")) Sort.select(a);
		if (alg.equals("Shell")) Sort.shell(a);
//		if (alg.equals("Merge")) Merge.sort(a);
//		if (alg.equals("Quick")) Quick.sort(a);
//		if (alg.equals("Heap")) Heap.sort(a);
		return timer.elapsedTime();
	}
	/**
	 * 生成T个长度为N的数组排序，并使用某个排序算法 ，计算排序T数组总共需要多长时间
	 * @param alg 算法的名称
	 * @param N	数组的长度
	 * @param T 数组的个数
	 * @return
	 */
	public static double timeRandomInput(String alg, int N, int T){ 
		// 使用算法1将T个长度为N的数组排序
		double total = 0.0;
		Double[] a = new Double[N];
		for (int t = 0; t < T; t++)
		{ // 进行一次测试（生成一个数组并排序)
			for (int i = 0; i < N; i++)
			a[i] = StdRandom.uniform();
			total += time(alg, a);
		}
		return total;
	}
	
	public static void main(String[] args){
		String[] algs = {"Insertion","Selection","Bobble","Shell"};
		int N = 10000;//数组的大小
		int T = 100;//数组的个数
		double t0 = timeRandomInput(algs[0], N, T); // 算法1的总时间
		double t1 = timeRandomInput(algs[1], N, T); // 算法1的总时间
		double t2 = timeRandomInput(algs[2], N, T); // 算法2的总时间
		double t3 = timeRandomInput(algs[3], N, T); // 算法3的总时间
		StdOut.printf("For %d random Doubles\n", N);
		StdOut.printf("%s is %.1f times faster than %s\n",algs[3], t0/t3, algs[0]);
		StdOut.printf("%s is %.1f times faster than %s\n",algs[3],t1/t3, algs[0]);
		StdOut.println("t0="+t0);
		StdOut.println("t1="+t1);
		StdOut.println("t3="+t3);
	}
}
