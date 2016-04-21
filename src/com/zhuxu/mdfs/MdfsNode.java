package com.zhuxu.mdfs;

/**
 * @author mac
 * @category mdfs中用来仿真测试的移动终端节点
 * 
 * */
public class MdfsNode {
	private int blockNum;
	private int id;
	private int netLevel;
	public  MdfsNode() {
		this.blockNum=0;
		this.netLevel=10;
		this.id=(int)System.currentTimeMillis();
	}
	public MdfsNode(int id,int netLevel){
		this.id = id;
		this.netLevel = netLevel;
		this.blockNum=0;
	}
	
	public int getBlockNum() {
		return blockNum;
	}
	public void setBlockNum(int blockNum) {
		this.blockNum = blockNum;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getNetLevel() {
		return netLevel;
	}
	public void setNetLevel(int netLevel) {
		this.netLevel = netLevel;
	}
	//给该节点增加一个文件块
	public void addOneBlockNum() {
		this.blockNum += 1;
	}
	//给该节点增加指定个数文件块
	public void addBlockNum(int addBlockMun) {
		this.blockNum += addBlockMun;
	}
}
