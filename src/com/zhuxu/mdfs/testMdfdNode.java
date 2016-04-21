package com.zhuxu.mdfs;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

/**
 * @author mac
 * 
 */

public class testMdfdNode {
	public static void main(String[] args) {
		//所有的默认等级一样
		int netLevel =9;
		List<MdfsNode> nodes = new ArrayList<MdfsNode>();
		for (int i = 0; i <100; i++) {
			MdfsNode aMdfsNode = new MdfsNode(i,netLevel);
			nodes.add(aMdfsNode);
		}
		//添加文件块，指定个数文件块
		for (int j = 0; j < 10; j++) {
			int value = (int)(Math.random()*100);
			nodes.get(value).addOneBlockNum();
		}
		Iterator<MdfsNode> iterator = nodes.iterator();
		while (iterator.hasNext()) {
			MdfsNode aMdfsNode=iterator.next();
			System.out.println(aMdfsNode.getId()+"\t"+aMdfsNode.getBlockNum());
		}
	}
}
