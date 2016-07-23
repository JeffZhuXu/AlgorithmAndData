/**
 * 
 */
package com.zhuxu.test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author mac
 * 
 */
public class B extends A {
	
	public B() {
		System.out.println("子类B的默认构造函数");
	}
	
	@Override
	public String toString() {
		return "123";
	}
	public static int add(int...a){
		int s =0;
		  for(int i=0;i<a.length;i++){
		     s+=a[i];
		}
		  List<String> aList = new ArrayList<String>();
		return s;
		}

	public static void main(String[] args) {
		B b = new B();
		int[] aa = new int[]{1,1,1,1,1,1};
		System.out.println(b.add(aa));
	}
	
}
