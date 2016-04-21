package com.zhuxu.number;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
/*
 * 2016.03.29
 * list类的相关操作
 * 
 * 
 * */
public class ListUtil {
	
	public static void main(String[] args) {
		List<Integer> arrayListNum = getArrayList();
		List<Integer> linkListNum = getLinkList();
		deleteEvenNum(arrayListNum);
		deleteEvenNum(linkListNum);
	}
	
	//删除list中的偶数函数
	public static void  deleteEvenNum(List<Integer> listNum) {
		long startTime = System.currentTimeMillis();
		ListIterator<Integer> iterator = listNum.listIterator();
		while (iterator.hasNext()) {
			if(iterator.next()%2==0){
				iterator.remove();
			}
		}
		System.err.println("程序运行时间："+(System.currentTimeMillis()-startTime)+"ms");
	}
	
	//以arraylist格式获取数据
	public static ArrayList<Integer> getArrayList() {
		ArrayList<Integer> numList = new ArrayList<Integer>();
		for (int i = 0; i < 200000; i++) {
			numList.add(i);
		}
		return numList;
	}
	//以LinkedList格式获取数据
	public static LinkedList<Integer> getLinkList() {
		LinkedList<Integer> numList = new LinkedList<Integer>();
		for (int i = 0; i < 200000; i++) {
			numList.add(i);
		}
		return numList;
	}
}
