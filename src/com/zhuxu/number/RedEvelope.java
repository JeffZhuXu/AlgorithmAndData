package com.zhuxu.number;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/*
 * 一堆红包，有一半以上是一个相同的金额，找出这个相同的金额
 * /
 */
public class RedEvelope {
	public static void main(String[] args) {
		Float[] moneys = new Float[]{1f,1f,1f,1f,1f,1f,0.5f,0.5f,0.5f,0.5f,0.3f,0.3f,0.3f,0.3f,0.3f,0.3f,0.3f,0.3f,0.3f,0.3f,0.3f,0.3f,0.3f,0.3f,0.3f};
		List<Evelope> evelopes = new ArrayList<Evelope>();
		for (int i = 0; i < moneys.length; i++) {
			Evelope aEvelope = new Evelope(moneys[i],0);
			if (!evelopes.contains(aEvelope)) {
				evelopes.add(aEvelope);
				System.out.println("添加红包");
			}else {
				evelopes.get(evelopes.indexOf(aEvelope)).addNumer(1);;
			}
		}
		Collections.sort(evelopes, new NumberComparctor());
		Evelope result = evelopes.get(0);
		System.out.println("红包金额："+result.size+" 红包个数："+result.number+" 总的红包个数："+moneys.length);
	}
	 static class Evelope implements Comparable<Evelope>{
		
		Float size=0f; //红包金额
		int number=0;	//红包个数
		public Evelope() {
		}
		public Evelope(Float size,int number) {
			this.size=size;
			this.number=number;
		}
		public void addNumer(int number) {
			this.number +=number;
		}
		
		public int compareTo(Evelope o) {
			if (this.size>=o.size) {
				return 1 ;
			}else {
				return 0 ;
			}	
		}
		@Override
		public boolean equals(Object o){
			Evelope aEvelope = (Evelope)o;
			if (this.size.equals(aEvelope.size)) {
				return true;
			}else {
				return false;
			}
		}
	}
	 static class NumberComparctor implements Comparator<Evelope>{
		public int compare(Evelope o1, Evelope o2) {
			return o2.number-o1.number;
		}
		 
	 }
}
