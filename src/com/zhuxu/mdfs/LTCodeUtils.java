package com.zhuxu.mdfs;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.Set;

import sun.java2d.loops.XORComposite;

/**
 * @author Jeff
 * @explain LT码程序
 * @time 2016.5.5
 * 
 * */

public class LTCodeUtils {
	
	public static void main(String[] args) {

		for (int i = 0; i < 20; i++) {
			
			Integer[] select = getSelectMessages(10);
			System.out.println("第"+i+"次抽取"+" 度数为："+select.length);
			for (int j = 0; j < select.length; j++) {
				System.out.println("第"+j+"个值是"+select[j]);
			}
		}
		
//		String originalString = "0000000000111111111100000000001111111111000000000011111111110000000000111111111100000000001111111111";
//		//信息分组长度是10
//		int length = 10;
//		//初始分组个数
//		int num = originalString.length()/10;
//		//保存所有初始信息分组的集合
//		List<OriginalMsg> originalMsgs = new ArrayList<OriginalMsg>();
//		//产生的编码个数
//		int encodeNum = 20;
//		for (int i = 0; i < num; i++) {
//			String aMessagee = originalString.substring(i*10,i*10+10);
//			OriginalMsg oneMsg = new OriginalMsg(i, aMessagee);
//			originalMsgs.add(oneMsg);
//		}
//		for (OriginalMsg aOriginalMsg:originalMsgs) {
//			System.out.println("分组编号："+aOriginalMsg.id);
//			System.out.println("分组信息："+aOriginalMsg.message);
//		}
		
	}
	
	/**
	 * @explain 初始信息组
	 * */
	public static class OriginalMsg implements Comparable<OriginalMsg>{
		//信息编号
		private int id;
		private String message=null;
		public OriginalMsg(){
		}
		//构造函数
		public OriginalMsg(int id) {
			this.id=id;
		}
		//构造函数
		public OriginalMsg(int id,String originalMessage) {
			this.id=id;
			this.message = originalMessage;
		}
		
		@Override
		public int compareTo(OriginalMsg o) {
			// TODO Auto-generated method stub
			return this.id-o.id;
		}
		//给原始信息组赋值
		public void addMessage(String message){
			this.message = message;
		}
		@Override
		public boolean equals(Object obj) {
			OriginalMsg o = (OriginalMsg)obj;
			if (this.id-o.id==0) {
				return true;
			}else {
				return false;
			}
		}
	}
	/**
	 * @explain 编码后的信息组
	 * */
	public static class EncodeMsg implements Comparable<EncodeMsg>{
		//编码组的度数
		private int degree;
		//编码后的值
		private String encodeMessage=null;
		//来源节点
		private LinkedList<OriginalMsg> originalMsgList = new LinkedList<OriginalMsg>();
		
		public EncodeMsg(){
		}
		public EncodeMsg(int degree,String encodeMessage){
			this.degree=degree;
			this.encodeMessage = encodeMessage;
		}
		public EncodeMsg(String encodeMsg,List<Integer> originalMessageId){
			this.encodeMessage=encodeMsg;
			this.degree=originalMessageId.size();
			//将原始编码分组信息添加到编码信息组上
			for (int i = 0; i < originalMessageId.size(); i++) {
				OriginalMsg originalMsg = new OriginalMsg(i);
				originalMsgList.add(originalMsg);
			}
		}
		@Override
		public int compareTo(EncodeMsg o) {
			// TODO Auto-generated method stub
			return this.degree-o.degree;
		}
		//异或一个父节点，度数减一
		public void deleteOriginalMsg(OriginalMsg oneMsg) {
			degree--;
			int length = oneMsg.message.length();
			String oneMessage = oneMsg.message;
			StringBuffer buffer = new StringBuffer();
			for (int i = 0; i < length; i++) {
				if(encodeMessage.charAt(i)==oneMessage.charAt(i)){
					buffer.append('0');
				}else {
					buffer.append('1');
				}
			}
			//给编码后的值重新赋值
			encodeMessage = buffer.toString();
		}
	}
	//获取度数以及随机数序号
	public static Integer[] getSelectMessages(int num){
		//均匀分配先吧
		int degree = 0;
		//概率分布
		Double[] rates = new Double[]{0.2,0.5,0.75,0.91,0.92,0.93,0.94,0.95,0.96,1d};
		//填充概率分布
//		for (int i = 0; i < num; i++) {
//			Double rate = 0.0000d;
//			Double a = Double.valueOf(num);
//			rate =i/a;
//			rates[i]=rate;
//		}
		Double selectValue=Math.random();
		for (int i = 0; i < rates.length; i++) {
			if (selectValue<=rates[i]) {
				degree=i+1;
				break;
			}
		}
		Integer[] selectMessages = getRandonNum(degree,num);
		return selectMessages;
	}
	/**
	 * @param degree 选随机数的个数
	 * @param num 总的随机数个数
	 * @return int[] 随机数集合
	 * 
	 * */
	public static Integer[] getRandonNum(int degree,int num) {
		 Integer[] numbers = new Integer[degree];
		 //set内的integer是不同的
			Set<Integer> set=new HashSet<Integer>();
			while(true){
				set.add((int)(Math.random()*num));
				if(set.size()==degree)
					break;
			} 
			numbers=(Integer[])set.toArray(numbers);
		 return numbers;
	}
}
