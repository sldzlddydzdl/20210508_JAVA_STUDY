package day20210508.fileEx01;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileCopy {
	public static void main(String[] args) {
		// 파일 카피를 구현
		// 아무이미지나 workspace 폴더에 넣어두고
		// 해당되는 이미지파일을 복사하여 현재 패키지 안쪽으로 넣어보자.
		// 준비물 : 복사할 이미지파일, 인풋스트림, 아웃풋스트림, 만들 파일
		
		// try - resource 방식으로 예외처리
		// try(생성할 객체){ 
		// 	   예외가 발생할 문장
		// } catch(예외 객체타입 e){
		//		
		// }
		// 이 방식은 try()에서 생성한 객체는 try가 끝나는 시점에 close()자동으로 호출한다.
		// finally 안해줘도 된다.
		
		File oriImageFile = new File("../pigeon.jpg");
		File copyImageFile = new File("C:/Users/rlaeh/eclipse-workspace/day20210508/src/day20210508/fileEx01" , "pigeon.jpg");
		
		// 인풋에는 원본과 연결한다.
		// 아웃풋에는 복사본 파일과 연결한다.
		try(FileInputStream fin = new FileInputStream(oriImageFile);
			FileOutputStream fout = new FileOutputStream(copyImageFile)){
			
			// 원본에서 읽어 본사본에 쓰자
			int data =-1;
			while((data = fin.read()) != -1) {
				fout.write(data);
			}
			System.out.println("파일복사 완료");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
