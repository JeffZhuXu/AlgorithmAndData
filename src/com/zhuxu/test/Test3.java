package com.zhuxu.test;

import java.util.Scanner;
//求两个输入的数之和
public class Test3 {
	public static void main(String[] args) {
		Scanner cinScanner = new Scanner(System.in);
		int a,b;
		while (cinScanner.hasNextInt()) {
			a = cinScanner.nextInt();
			b = cinScanner.nextInt();
			System.out.println(a+b);
		}
	}
}
