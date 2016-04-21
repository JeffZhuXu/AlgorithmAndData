package com.zhuxu.tool;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author mac
 * @deprecated list与array数组之间相互转换
 * 
 * */
public class ListArrayUtils {
	public static void main(String[] args) {
		ArrayList<String> listData = new ArrayList<String>() {{
				add("a");
				add("b");
			}};
			String[] arrayList=arrayListToArray(listData);
			for(String a:arrayList){
				System.out.println("list转array："+a);
			}
			
		String[] stringData  = new String[]{
			"a",
			"b"
		};
			List<String> list= arrayToArrayList(stringData);
			for(String b:list){
				System.out.println("array转list："+b);
			}
			
	}

	// list转array数组
	public static String[] arrayListToArray(List<String> dataList) {
		int size = dataList.size();
		String[] array = (String[]) dataList.toArray(new String[size]);
		return array;
	}

	// array数组转list
	public static List<String> arrayToArrayList(String[] arrayList) {
		List<String> listData = Arrays.asList(arrayList);
		return listData;
	}
}
