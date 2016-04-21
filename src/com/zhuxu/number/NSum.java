package com.zhuxu.number;

public class NSum {
	//求解一个序列的连续子序列的最大和,算法复杂度O(n3)
	public static int method1(int[] arr){
		float startTime = System.currentTimeMillis();
		int maxSum = 0;
		for (int i = 0; i < arr.length; i++) {
			for (int j = i; j < arr.length; j++) {
				int thisSum = 0;
				
				for (int k = i; k <= j; k++) {
					thisSum +=arr[k];
				}
				if (thisSum>maxSum) {
					maxSum=thisSum;
				}
			}
		}
		System.err.println("程序运行时间："+(System.currentTimeMillis()-startTime));
		return maxSum;
	}
	
	//求解一个序列的连续子序列的最大和,算法复杂度O(n2)
	public static int method2(int[] arr){
		float startTime = System.currentTimeMillis();
		int maxSum = 0;
		for (int i = 0; i < arr.length; i++) {
			int thisSum = 0;
			for (int j = i; j < arr.length; j++) {
				thisSum += arr[j];
				if (thisSum>maxSum) {
					maxSum=thisSum;
				}
			}
		}
		System.err.println("程序运行时间："+(System.currentTimeMillis()-startTime));
		return maxSum;
	}
	
	//求解一个序列的连续子序列的最大和,算法复杂度O(n)
	public static int method3(int[] arr){
		float startTime = System.currentTimeMillis();
		int maxSum=0,thisSum = 0;
		for (int i = 0; i < arr.length; i++) {
			thisSum += arr[i];
			if (thisSum>maxSum) {
				maxSum=thisSum;
			}else if (thisSum<0) {
				thisSum=0;
			} 
		}
		System.err.println("程序运行时间："+(System.currentTimeMillis()-startTime));
		return maxSum;
	}
	
	public static void main(String[] args) {
		int[] arr = new int[]{-1,-2,-3,1,2,3,4,-1,-2,-3};
		System.out.println("方法1数组中最大值："+method1(arr));
		System.out.println("方法2数组中最大值："+method2(arr));
		System.out.println("方法3数组中最大值："+method3(arr));
	}

}
