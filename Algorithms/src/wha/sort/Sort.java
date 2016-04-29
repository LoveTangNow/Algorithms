package wha.sort;

public class Sort {
	/**
	 * 选择排序 | 升序 
	 * 两层循环 每次找出第i小的值，放在数组的第i位
	 * @param a
	 */
	public static void select(Comparable[] a) {
		for (int i = 0; i < a.length; i++) {
			int min = i;
			for (int j = i + 1; j < a.length; j++) {
				if (SortApp.less(a[j], a[min]))
					min = j;
			}
			SortApp.exch(a, i, min);
		}
	}

	/**
	 * 插入排序 | 升序
	 * 两层循环 将第i+1位 与已经排好的序前i位依次比较，若比其小，则将i+1对应的数插入该处
	 * @param a
	 */
	public static void insert(Comparable[] a) {
		for (int i = 1; i < a.length; i++)  
			for (int j = i; (j>0) && SortApp.less(a[j],a[j-1]); j--) 
				SortApp.exch(a, j, j - 1);
	}

	/**
	 * 冒泡排序 | 升序
	 * 原理：每次循环，若第i个元素比i+1个元素大，则他们相互交换，第一轮循环能找出最大的数放在数组的最后，第二轮循环找出第二大的数放在倒数第二位...
	 * @param a
	 */
	public static void bubble(Comparable[] a) {
		int n = a.length;
		for(int i = 0; i < n; i++)
			for(int j = 0; j < n-i-1; j++ )
				if(SortApp.less(a[j+1], a[j])) SortApp.exch(a, j, j+1);
	}

	/**
	 * 希尔排序 | 升序
	 * 将数组变为h有序：第i位，第i+h位，第i+2h位,...是有序的。
	 * 按一定规则初始化h，将数组变为h有序的过程中，参量h递减至1
	 * @param a
	 */
	public static void shell(Comparable[] a) { //
		int N = a.length;
		int h = 1;
		while (h < N / 3)
			h = 3 * h + 1; // 1, 4, 13, 40, 121, 364, 1093, ...
		while (h >= 1) { // 
			for (int i = h; i < N; i++) { // 将a[i]插入到a[i-h], a[i-2*h], a[i-3*h]... 之中
				for (int j = i; j >= h && SortApp.less(a[j], a[j - h]); j -= h){
					SortApp.exch(a, j, j - h);
				}
			}
			h = h / 3;
		}
	}

}
