
public class Main2 {

	public static void transform(int num,int n){
		//参数num为输入的十进制数，参数n为要转换的进制
		int array[]=new int[100];
		int location=0;
		while(num!=0){//当输入的数不为0时循环执行求余和赋值
			int remainder=num%n;
			num=num/n;
			array[location]=remainder;//将结果加入到数组中去
			location++;
		}
		show(array,location-1);

	}
	private static void show(int[] arr,int n){
		int sum =0;
		for(int i=n;i>=0;i--){
			if(arr[i]>9){
				sum+=Integer.parseInt(((char)(arr[i]+55)+""));
				System.out.print((char)(arr[i]+55));
			}
			else
				sum+=Integer.parseInt(arr[i]+"");
				System.out.print(arr[i]+"");
		}
		System.out.println(sum);
	}
	public static void main(String[] args)
	{
		// 测试用例
		Main2 t=new Main2();
		t.transform(18, 8);
	}
}
