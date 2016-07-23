package com.zhuxu.number;

import java.text.DecimalFormat;


/**
 * @author mac
 * @explian 测试数字格式化
 * @time 16.5.12
 *
 */
public class TestDecimalFormat {
	public static void main(String[] args) {

		TestDecimalFormat tdf = new TestDecimalFormat();

		tdf.format("###,###.###", 1122.3);
		tdf.format("###,###.###", 1122.34567);
		tdf.format("###,###.###", 111222.34567);
		tdf.format("###,###.###", 111111222.34567);
		tdf.format("000", 1);
		tdf.format("000000", 1);
		tdf.format("000000.000", 1);
		tdf.format("###,###.###￥", 112222.345);
		tdf.format("###,###.###￥", 11112222.34533);
		tdf.format("000,000.000￥", 111222.345);
		tdf.format("00,000,000.000￥", 111222.345);
		tdf.format("00,000,000.00000￥", 111222.345);

		tdf.format("##.###%", 0.12345678);
		tdf.format("00.###%", 0.0345678);
		tdf.format("###.###\u2030", 0.345678); // 乘以1000，并显示为千分数
	}

	public void format(String pattern, double value) {
		DecimalFormat df = null;
		df = new DecimalFormat(pattern);
		String str = df.format(value);
		System.out.println(value + "使用" + pattern + "格式化数字后" + "value:" + str);

	}
}
