package day20210508.fileEx01;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileOutputStreamEx01 {
	// 인풋스트림
//	-> 읽고자 하는 파일과 연결 : read()
	
	// 아우풋 스트림
//	-> 쓰고자 하는 프로그램과 연결을 하요사용 : write()
	
	public static void main(String[] args) {
		// 파일에 데이타를 작성하는 코드 
		// 준비물 : 입력할 파일, 데이터, 아웃풋스트림
		// new File("쓰고자 하는 파일의 위치+파일명");
		// 파일의 주소 : 상대경로, 절대경로
		// 상대경로 : 상대적인 기준으로부터 위치를 표기 , 항상 비교할 대상이 있어야한다. 예) ex01.txt
		// 절대경로 : 루트에서부터의 위치 , 예)c:/User/workspace/ex01.txt
		// 현재위치 상위 폴더는 (..) 으로 표기 , 현재폴더는 (.) 으로 표기 
		File file = new File("src/day20210508/fileEx01/ex01.txt");
				
		//아웃풋 스트림 변수 생성
		FileOutputStream fout = null;
		
		try {
			// 작성하는 기능이있는 아웃풋 스트림 객체를 생성
			fout = new FileOutputStream(file);
						
			// 파일에 작성
			fout.write(65);
			System.out.println("파일에 데이타 65를 씀");
			fout.write(321); // 255 을 알아서 빼줌 
			System.out.println("파일에 데이타 321을 씀");
			fout.write('A'); // 65  
			System.out.println("파일에 데이타 A을 씀");
			
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			// 파일과 연결되어있는 아웃풋 스트림 객체를 닫아준다.
			// fout에 객체가 없을 수도 있으므로 fout null 체크를 해야함 안그러면 nullpointException
			// 에러가 날수도 있음 
			if(fout != null) {
				try {
					fout.close();
				} catch (IOException e) {
					// close 할때도 IOException이 발생할수 있끼때문에
					e.printStackTrace();
				}
			}
		}
		
		
	}
}
