package day20210508.fileEx01;

import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class DataOutputStreamEx01 {
	public static void main(String[] args) {
		// byte가 아닌 다른 자료형도 파일에 작성할 수 있도록 해준 아이 : DataOutputStream
		// 보조스트림이라서 씽크스트림이 필요함.
		
		try(DataOutputStream dout = new DataOutputStream(
			new FileOutputStream("src/day20210508/fileEx01/DataIOEx01.txt"))){
			
			// 1000이라는 숫자를 파일에 저장하려면? 
			dout.writeInt(1000);
			
			// 문자열도 넣어보자
			dout.writeUTF("안녕하세요");
			
			dout.flush();
			System.out.println("파일 작성 완료");
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
