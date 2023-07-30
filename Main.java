package hello4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Serializable;
import java.net.InetAddress;
import java.net.Socket;

class Student implements Serializable{
	private String name;
	private int age;
	private int grade;
	
	//构造
	public Student(String name,int age,int grade) {
		this.name=name;
		this.age=age;
		this.grade=grade;
	}
	
	public String toString() {
		return name+" "+age+" "+grade;
	}
}

public class Main{
	public static void main(String[] args) {
		try {
			Student s1=new Student("John",18,5);
			System.out.println(s1);
			//构造一个可以直接把s1写到文件里的方式
			ObjectOutputStream out=new ObjectOutputStream(
					new FileOutputStream("a.dat"));
			out.writeObject(s1);
			out.close();
			//读出来
			ObjectInputStream in=new ObjectInputStream(
					new FileInputStream("a.dat"));
			Student s2=(Student)in.readObject();
			System.out.println(s2);
			in.close();
			System.out.println(s1==s2);//判断是否指向同一个对象
		}catch(IOException e){
			e.printStackTrace();
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

//public class Main {
//
//	public static void main(String[] args) {
//		try {
//			Socket socket=new Socket(InetAddress.getByName("localhost"),12345);
//			//写文本要有PrintWriter
//			PrintWriter out=new PrintWriter(
//					new BufferedWriter(
//							new OutputStreamWriter(
//									socket.getOutputStream())));
//			out.println("hello");
//			out.flush();
//			BufferedReader in=new BufferedReader(
//					new InputStreamReader(
//							socket.getInputStream()));
//			out.close();
//			
//			//从远端服务器收东西
//			BufferedReader in=new BufferedReader(
//					new InputStreamReader(
//							socket.getInputStream()));
//			String line;
//			line=in.readLine();
//			System.out.println(line);
//			socket.close();
//		}catch(IOException e) {
//			e.printStackTrace();
//		}
//		
//
//	}
//
//}
