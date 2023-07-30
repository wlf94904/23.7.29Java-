package hello3;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		System.out.println("hello world");
		//构造一个字节数组，它有10个字节
		byte[] buf=new byte[10];
		//遍历数组
		for(int i=0;i<buf.length;i++) {
			buf[i]=(byte)i;//int需要强制转换成字节
			
			
		}
		try {
			//不仅仅可以写字节用DataOutputStream
			PrintWriter out=new PrintWriter(
					new BufferedWriter(
							new OutputStreamWriter(
									new FileOutputStream("a.txt"))));
//			FileOutputStream out=new FileOutputStream("a.dat");//建立一个FileOutputStream的对象
			//用FileOutputStream只能写字节
//			out.write(buf);
			int i=12;
			out.println(i);
			out.close();
			BufferedReader in=new BufferedReader(
					new InputStreamReader(
							new FileInputStream("src/hello3/Main.java")));
			String line;
			while((line=in.readLine())!=null) {
				System.out.println(line);
			}
//			DataInputStream in=new DataInputStream(
//					new BufferedInputStream(
//							new FileInputStream("a.dat")));
//			int j=in.readInt();
//			System.out.println(j);
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		//文件名叫a.dat
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		

	}

}
