package day20210508.fileEx01;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class FileCopy02 {
	public static void main(String[] args) {
		
		// 파일 업로드되었을 때 같은파일명은 어떻게 처리하지?
		// 파일명에 날짜를 추가하는방법
		// 년 월 일 시 분 초 
		
		
		// 파일복사를 구현하는데, 속도를 올리기 위해
		File oriImageFile = new File("../pigeon.jpg");
		
		LocalDateTime today = LocalDateTime.now();
		String todayStr = today.format(DateTimeFormatter.ofPattern("yyyyMMddHHmmss"));
		String fileName = "pigeon_"+todayStr+".jpg";
		
		File copyImageFile = new File("C:/Users/rlaeh/eclipse-workspace/day20210508/src/day20210508/fileEx01" , fileName);

		byte[] bagagi = new byte[1024];
		
		// 인풋에는 원본과 연결한다.
		// 아웃풋에는 복사본 파일과 연결한다.
		try(FileInputStream fin = new FileInputStream(oriImageFile);
				FileOutputStream fout = new FileOutputStream(copyImageFile)){
			
			// 원본에서 읽어 본사본에 쓰자
			while(fin.available() > 0) {
				fout.write(bagagi, 0, fin.read(bagagi, 0, bagagi.length));
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
