package day20210508.fileEx01;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FileInputStreamEx01 {
	public static void main(String[] args) {
		// 파일을 읽어오는 기능을 구현
		// 준비물 : 읽어올 파일 , 파일인풋스트림객체
		// 파일객체를대신 파일주소로 가능함
		
		FileInputStream fin = null;
		
		try {
			// 파일 인풋에 파일을 연결한 객체생성
			fin = new FileInputStream("src/day20210508/fileEx01/ex01.txt");
			
			// 한바이트 읽기
//			int data = fin.read();
//			System.out.println(data);
//			data = fin.read();
//			System.out.println(data);
//			data = fin.read();
//			System.out.println(data);
//			data = fin.read(); // -1을 반환하게 됨.
//			System.out.println(data);
			
			int data = -1;
			
			while((data = fin.read()) != -1 ) {
				System.out.println(data);
			}
			
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if(fin != null) {
				try {
					fin.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
		
		
	}
}
