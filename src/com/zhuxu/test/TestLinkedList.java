package com.zhuxu.test;

import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

/*
 * @zhuxu
 * 测试linkedlist
 * */
public class TestLinkedList {
	
	public static void main(String[] args) {
		List<String> foodList = new LinkedList<String>();
		foodList.add("香蕉");
		foodList.add("苹果");
		foodList.add("雪梨");
		System.out.println(foodList.get(1));
		ListIterator<String> itr =  foodList.listIterator();
		while (itr.hasNext()) {
			String sString = itr.next();
			if( sString.equals("雪梨")){
				itr.remove();
				continue;
			}
			System.out.println(sString);
		}
	}
}
