package wha.basic;

public class One {
	/**
	 *求一个数的平方根
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
	 * 二分法查找
	 * @param key
	 * @param a
	 * @param lo
	 * @param hi
	 * @return
	 */
	public static int seek(int key,int[] a,int lo,int hi){
		if(lo > hi) return -1;
		int mid = (lo + hi)/2;
		if(key > a[mid])
			return seek(key,a,mid + 1,hi);
		else if(key < a[mid])
			return seek(key,a,lo,mid - 1);
		else return mid;
	}
	public static void main(String[] args) {
		//System.out.println(isPrime(123));
		int[] a = {1,3,6,8,11,14,18,23,67,89,112};
		System.out.println(seek(6,a,0,a.length-1));
	}
}
