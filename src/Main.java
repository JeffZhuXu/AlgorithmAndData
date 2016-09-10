import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Main {
	public static void main(String[] args) {
		Scanner cin = new Scanner(System.in);
		List<Integer> nodes = new ArrayList<Integer>();

		int nodeNum=0;
		while (cin.hasNextLine()) {
			nodeNum= Integer.parseInt(cin.nextLine());
			break;
		}
		for (int i = 0; i < nodeNum; i++) {
//			nodes.add(Integer.parseInt(cin.nextLine()));
			System.out.println(lukeyNum(Integer.parseInt(cin.nextLine())));
		}
//		for (int i = 0; i < nodes.size(); i++) {
//			System.out.println(lukeyNum(nodes.get(i)));
//		}

	}
	public static int lukeyNum(int num) {
		int result =0;
		for (int i = 1; i <= num; i++) {
			if (isLukey(i)) {
				result++;
			}
		}
		return result;
	}
	//判断该数字书否是幸运数
	public static boolean isLukey(int num) {
		boolean result = false;
		String ten = num +"";
		String binary = Integer.toBinaryString(num);
		int tenSum=0;
		int binarySum=0;
		for (int i = 0; i < ten.length(); i++) {
			tenSum+=Integer.parseInt(ten.charAt(i)+"");
		}
		for (int i = 0; i < binary.length(); i++) {
			binarySum+=Integer.parseInt(binary.charAt(i)+"");
		}
		if (tenSum==binarySum) {
			result=true;
		}
		return result;
	}
}
