package hello2;

import java.io.IOException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		System.out.println("hello world");
//		Scanner in=new Scanner(System.in);
		//下面的是代替上面这一行的读入功能的
		//做一个字节的数组
		byte[] buffer=new byte[1024];//1k字节大的buffer
		try {
			int len=System.in.read(buffer);//len是告诉我们读了多少东西
			String s=new String(buffer,0,len);//用这个buffer里面从0开始的这么多字节来构造一个String
			System.out.println("读到了"+len+"字节");//字节的个数，汉字一个字符是两个字节，回车也是一个字符一个字节
			System.out.println(s);//输出s是多少，即输出那个字符串
			System.out.println("s的长度是："+s.length());//字符的个数
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}//read的到buffer里面去
		
		

	}

}
