package wha.basic;

import edu.princeton.cs.algs4.StdOut;

public class One {
	/**
	 *求一个数的平方根(牛顿)
	 * @param a
	 * @return
	 */
	public static double sqrt(double a){
		if(a<0)	return Double.NaN;
		double err = 1e-15;
		double x = a;//初始值
		while(Math.abs(x-a/x)>err*x){
			x = (x + a/x)/2;
		}
		return x;
	}
	/**
	 * 判断一个数是否是素数（1和0既非素数也非合数）
	 * @param N
	 * @return
	 */
	public static boolean isPrime(int N){
		if(N<2)		return false;
		for(int i=2 ; i*i<=N; i++)
			if(N%i==0)	return false;
		return true;
	}
	/**
	 * 二分法查找的递归实现
	 * @param key
	 * @param a
	 * @param lo
	 * @param hi
	 * @return
	 */
	public static int rank0(int key,int[] a,int lo,int hi){
		if(lo > hi) return -1;
		int mid = (lo + hi)/2;
		if(key > a[mid])
			return rank0(key,a,mid + 1,hi);
		else if(key < a[mid])
			return rank0(key,a,lo,mid - 1);
		else return mid;
	}
	/**
	 * 二分法查找的非递归实现
	 * @param key
	 * @param a
	 * @return
	 */
	public static int rank(int key, int[] a){ // 数组必须是有序的
	int lo = 0;
	int hi = a.length - 1;
	while (lo <= hi){ // 被查找的键要么不存在，要么必然存在于a[lo..hi] 之中
		int mid = lo + (hi - lo) / 2;
		if (key < a[mid]) hi = mid - 1;
		else if (key > a[mid]) lo = mid + 1;
		else return mid;
	}
	return -1;
	}
	//static int count = 0;
	/**
	 * 求斐波那契数列的递归实现(求得是f(N)) | 时间复杂度 2^N
	 * 递归调用的次数是2^x级别的，但是我到现在找不出确切值，希望你能找出来：）
	 * @param N
	 * @return
	 */
	public static long Fibo(int N){
		//count++;
		if (N == 0) return 0;
		if (N == 1) return 1;
		return Fibo(N-1) + Fibo(N-2);
	}
	/**
	 * 求斐波那契数列的非递归实现(求得是f(N)) | 时间复杂度 :N
	 * 将每次计算存在数组中，只调用N次
	 * @param N
	 * @return
	 */
	public static long Fibo_n(int N){
		long[] a = new long[N+1];
		for (int i = 0; i < a.length; i++)
			getF(i,a);
		return getF(N,a);
	}
	private static long getF(int N,long[] a){
		if(N==0||N==1) a[N] = N;
		if(N>1){
			a[N]=a[N-1]+a[N-2];
		}
		return a[N];
	}
	/**
	 * 用数学公式作弊的斐波那契求法 | 时间复杂度 log(N)
	 * fi=(1+Math.sqrt(5))/2;
	 * fibo(n) =round( fi^n/sqrt(5) ) 
	 * @param N
	 */
	public static long Fibo_c(int N){
		double fi = (1+Math.sqrt(5))/2;
		long fibo = Math.round(Math.pow(fi, N)/Math.sqrt(5));
		return fibo;
	}
	/**
	 * 用矩阵（matrix）求取斐波那契数列
	 * 公式：[(Fn+1 Fn),(Fn Fn-1)]=[(1 1),(1 0)]^n
	 * @param N
	 * @return
	 */
	public static long Fbo_m(int N){
		//Todo 
		return 0;
	}
	/**
	 * 求二项分布
	 * @param args
	 */
	public static double binomial(int N, int k, double p)
	{
		if (N == 0 && k == 0) return 1.0; 
		if (N < 0 || k < 0) return 0.0;
		return (1.0 - p)*binomial(N-1, k, p) + p*binomial(N-1, k-1,p);
	}
	public static void main(String[] args) {
			StdOut.println(Fibo(10));
		
	}
}
