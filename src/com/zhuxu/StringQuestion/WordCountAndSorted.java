package com.zhuxu.StringQuestion;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.StringTokenizer;


/*
 * zhuxu
 * 对英文进行单词统计，并按从大到小进行排列
 * */
public class WordCountAndSorted {

	public static void main(String[] args) {
			String sentence = "i am not happy.Hello!He is good.i am i";
			method1(sentence);
			method2(sentence);
			
	}
	//方法1，用类来做，单词是一个类，然后用collections来操作
	public static void method1(String word) {
		String wordString = word;
		//split后面跟的是正则表达式哦
		String[] wordlList = wordString.split(" |,|\\?|\\.|!");
		List<Word> words = new ArrayList<Word>();
		for (int i = 0; i < wordlList.length; i++) {
			String content = wordlList[i];
			//当是“，. 空格”的时候，不算，排除掉
			if ((content.indexOf(" ")>-1)||(content.equals(",")||(content.equals(".")))) {
				break;
			}else {
				Word aWord = new Word(wordlList[i], 1);
				if (!words.contains(aWord)) {
					words.add(aWord);
				}else {
					words.get(words.indexOf(aWord)).addCount(1);;
				}
			}
		}
		Collections.sort(words);
		int wordLength = words.size();
		
		System.err.println("一共 "+wordLength+" 个单词");
		for (int i = 0; i < wordLength; i++) {
			System.err.println("第" + (i+1) + "个单词 " + words.get(i).content + " 单词个数：" + words.get(i).count);
		}
	}
	//通过map来保存字符即字符个数（只适合对象只有两个属性，一个是内容，一个是个数，如果对象超过两个属性，那么就最好用类来实现了）
	public static void  method2(String word) {
		String words = word;
		int wordCount=0;
		Map<String, Integer> map=new HashMap<String, Integer>();
		StringTokenizer tokenizer = new StringTokenizer(words);
		while (tokenizer.hasMoreTokens()) {
			String aWord = tokenizer.nextToken(" ,.?!\"\"''\n");
			if (map.containsKey(aWord)) {
				int count = map.get(aWord);
				map.put(aWord, count+1);
			}else {
				map.put(aWord, 1);
			}
		}
		List<Map.Entry<String, Integer>> wordInfoList = new ArrayList<Map.Entry<String, Integer>>(map.entrySet());
		Collections.sort(wordInfoList, new Comparator<Map.Entry<String, Integer>>() {
		public int compare(Map.Entry<String, Integer> o1,Map.Entry<String, Integer> o2){
			return (o2.getValue()-o1.getValue());
		}
		});

		System.err.println("共"+wordInfoList.size()+"个单词");
		for (int i = 0; i < wordInfoList.size(); i++) {
			Entry<String, Integer> aWordEntry = wordInfoList.get(i);
			System.err.println("第"+(i+1)+"个单词；"+aWordEntry.getKey()+" 个数："+aWordEntry.getValue());
		}
	}
	
	static class Word implements Comparable<Word> {
		@Override
		public boolean equals(Object obj) {
			Word aWord = (Word) obj;
			if (aWord.content.equals(this.content)) {
				return true;
			} else {
				return false;
			}
		}
		String content;
		int count;

		public Word() {
		}

		public Word(String content, int count) {
			this.content = content;
			this.count = count;
		}

		public void addCount(int addCount) {
			this.count += addCount;
		}

		public int compareTo(Word o) {
			// 个数从大到小排列
			return o.count - this.count;
		}

	}

}
