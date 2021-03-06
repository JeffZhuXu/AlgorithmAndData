package com.zhuxu.sort;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import sun.awt.geom.AreaOp.AddOp;

/**
 * @author mac\
 * 
 * */
public class SortUtils {
	private static boolean a;

	public static void main(String[] args) {
		int[] data ={ 49, 38, 65, 97, 76, 13, 27, 49, 78, 34, 12, 64, 1 };
		shellSort(data);
	}

	/**
	 * @exception 选择排序
	 * @exception 可靠排序
	 * @author mac
	 * @param List
	 *            <String> sortList,boolean sortType ture 升序，false 降序
	 * */
	public static void selectSort(List<String> data, boolean sortType) {
		int listSize = data.size();
		for (int i = 0; i < listSize; i++) {
			int position = i;
			String stringValue = data.get(i);
			for (int j = i + 1; j < listSize; j++) {
				if (sortType == true) {
					if (data.get(j).compareTo(stringValue) < 0) {
						position = j;
						stringValue = data.get(j);
					}
				} else {
					if (data.get(j).compareTo(stringValue) > 0) {
						position = j;
						stringValue = data.get(j);
					}
				}
			}
			if (position != i) {
				data.set(position, data.get(i));
				data.set(i, stringValue);
			}
		}
	}

	/**
	 * @exception 插入排序
	 * @exception 可靠排序
	 * @exception 最合适用linkedlist
	 * @author zhuxu
	 * @param List
	 *            <String> sortList,boolean sortType ture 升序，false 降序
	 * */
	public static void insertSort(List<String> data, boolean sortType) {
		int listSize = data.size();
		// 插入排序用链表来做的话算法复杂度比较低
		// LinkedList<String> newData = (LinkedList<String>) data;
		for (int j = 0; j < listSize; j++) {
			String value = data.get(j);
			for (int i = 0; i < j; i++) {
				// 升序
				if (sortType) {
					if ((data.get(i).compareTo(value) > 0)) {
						data.remove(j);
						data.add(i, value);
						break;
					}
					System.out.println("升序");
				} else if (!sortType) {
					// 降序
					if ((data.get(i).compareTo(value) < 0)) {
						data.remove(j);
						data.add(i, value);
						break;
					}
					System.out.println("降序");
				}
			}
		}
	}

	/**
	 * @exception 冒泡排序
	 * @exception 可靠排序
	 * @exception 最合适用linkedlist
	 * @author zhuxu
	 * @param List
	 *            <String> sortList,boolean sortType ture 升序，false 降序
	 * */
	public static void bubbleSort(String[] data, boolean sortType) {
		int size = data.length;
		boolean a;
		if (!(size > 0)) {
			return;
		}
		// 升序
		if (sortType) {
			for (int i = size - 1; i >= 0; i--) {
				String value = null;
				for (int j = 0; j <= i; j++) {
					if (value == null) {
						value = data[j];
					}
					if ((data[j].compareTo(value) >= 0)) {
						value = data[j];
					} else {
						data[j - 1] = data[j];
						data[j] = value;
					}
				}
			}
			// 降序
		} else if (!sortType) {
			for (int i = size - 1; i >= 0; i--) {
				String value = null;
				for (int j = 0; j <= i; j++) {
					if (value == null) {
						value = data[j];
					}
					if ((data[j].compareTo(value) <= 0)) {
						value = data[j];
					} else {
						data[j - 1] = data[j];
						data[j] = value;
					}
				}
			}
		}
	}

	/**
	 * @author mac
	 * @category 快速排序
	 * 
	 * */
	public static void quickSort(int[] array) {
		if (array != null) {
			quickSort(array, 0, array.length - 1);
		}
	}

	private static void quickSort(int[] array, int beg, int end) {
		if (beg >= end || array == null)
			return;
		int p = partition(array, beg, end);
		quickSort(array, beg, p - 1);
		quickSort(array, p + 1, end);
	}

	/**
	 * @author mac
	 * @category 快排使用的分区
	 * 
	 * */
	private static int partition(int[] array, int beg, int end) {
		int last = array[end];
		int i = beg - 1;
		for (int j = beg; j <= end - 1; j++) {
			if (array[j] <= last) {
				i++;
				if (i != j) {
					array[i] = array[i] ^ array[j];
					array[j] = array[i] ^ array[j];
					array[i] = array[i] ^ array[j];
				}
			}
		}
		if ((i + 1) != end) {
			array[i + 1] = array[i + 1] ^ array[end];
			array[end] = array[i + 1] ^ array[end];
			array[i + 1] = array[i + 1] ^ array[end];
		}
		return i + 1;
	}

	// collections.sort自带的排序，可用用来排序整形、浮点型、字符串等非自定义类型的排序,采用默认的规则
	public ArrayList<String> collectionsSort(ArrayList<String> data) {
		ArrayList<String> list = data;

		return data;
	}

	// collections.sort自带的排序，可用用来排序整形、浮点型、字符串等非自定义类型的排序,采用新建指定的规则,自定义比较器
	public ArrayList<String> collectionsTypeSort(ArrayList<String> data) {
		ArrayList<String> list = data;

		return data;
	}

	/**
	 * @exception 希尔排序
	 * @exception 不可靠排序
	 * @author zhuxu
	 * @param int[]
	 * @return null
	 * */	
	public static void shellSort(int[] data) {
		int[] a = data;
		System.out.println("排序之前：");
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}
		System.out.println("\r\n");
		// 希尔排序
		int d = a.length;
		while (true) {
            d=d/2;
            for(int x=0;x<d;x++)
            {
                for(int i=x+d;i<a.length;i=i+d)
                {
                    int temp=a[i];
                    int j;
                    for(j=i-d;j>=0&&a[j]>temp;j=j-d)
                    {
                        a[j+d]=a[j];
                    }
                    a[j+d]=temp;
                }
            }
			if (d == 1) {
				break;
			}
		}
		System.out.println("排序之后：");
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}
	}
}
 