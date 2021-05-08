package day20210508.fileEx01;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class DataInputStreamEx01 {
	public static void main(String[] args) {
		try(DataInputStream din = new DataInputStream(
			new FileInputStream("src/day20210508/fileEx01/DataIOEx01.txt"))){
			
			// 쓴 자료형과 똑같이 읽어줘야 한다.
			int data = din.readInt(); // 4바이트를 읽어옴
			String str = din.readUTF(); // 문자열로 읽어옴
			
			System.out.println("정수 : " + data);
			System.out.println("문자열 : "+ str);
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}


