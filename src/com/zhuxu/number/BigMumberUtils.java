/**
 * 
 */
package com.zhuxu.number;

import java.math.BigDecimal;
import java.math.BigInteger;

import sun.awt.geom.AreaOp.AddOp;

/**
 * @author mac
 * @explain 大整数处理类
 * @time 16.5.13
 *
 */
public class BigMumberUtils {
	public static void main(String[] args) {
		System.out.println(addBigInteger("11111111111111111111111111111111", "11111111111111111111111111111111"));
		System.out.println(divideBigDecimal("1", "8",2));
	
	}
	
	/**
	 * @param num1
	 * @param num2
	 * @return BigInteger
	 * @explain 大整数相加
	 */
	public static BigInteger addBigInteger(String num1,String num2){
		BigInteger number1 = new BigInteger(num1);
		BigInteger number2 = new BigInteger(num1);
		return number1.add(number2);
	}
	/**
	 * @explain 大小数除法
	 * @param num1
	 * @param num2
	 * @return 除结果
	 */
	public static BigDecimal divideBigDecimal(String num1,String num2,int b){
		BigDecimal number1 = new BigDecimal(num1);
		BigDecimal number2 = new BigDecimal(num2);
		System.out.println(number1);
		System.out.println(number2);
		return number1.divide(number2,b,BigDecimal.ROUND_HALF_EVEN);
	}
	

}
