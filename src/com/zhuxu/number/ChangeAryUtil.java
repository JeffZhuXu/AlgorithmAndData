package com.zhuxu.number;

/*
 * 10进制与其他进制相互转换
 * */
public class ChangeAryUtil {
	public static void tenTo(int num) {
		System.out.println(Integer.toHexString(num).toString());
		System.out.println(Integer.toBinaryString(num).toString());
		System.out.println(Integer.toOctalString(num).toString());
		System.out.println(Integer.valueOf("FFFF", 16));
		System.out.println(Integer.valueOf("666", 8).toString());
		System.out.println(Integer.valueOf("0101", 2).toString());
	}

	public static void main(String[] args) {
		tenTo(100);
	}
}
