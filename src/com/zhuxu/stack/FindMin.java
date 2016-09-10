package com.zhuxu.stack;

import java.util.Iterator;
import java.util.Stack;

/**
 * @author mac
 * @info 定义栈的数据结构，请在该类型中实现一个能够得到栈最小元素的min函数。
 * 
 */
public class FindMin {
	public static Stack<Integer> stack = new Stack<Integer>();

	public static void main(String[] args) {
		FindMin aSolution = new FindMin();
		aSolution.push(1);
		aSolution.push(2);
		System.out.println(aSolution.min());
	}

	public void push(int node) {
		stack.push(node);
	}

	public void pop() {
		stack.pop();
	}

	public int top() {
		return stack.peek();
	}

	public int min() {
		int min = stack.peek();
		Iterator<Integer> stackIterator = stack.iterator();
		while (stackIterator.hasNext()) {
			int a = stackIterator.next();
			if (a < min) {
				min = a;

			}

		}
		return min;
	}
}
