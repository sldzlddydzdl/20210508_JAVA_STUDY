package day20210508.fileEx01;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class BufferedIOStream {
	public static void main(String[] args) {
		// 파일을 인풋, 아웃풋 스트림에 연결 
		// 인풋, 아웃풋 스트림을 버퍼스트림에 연결
		
		File oriImageFile = new File("../pigeon.jpg");
		
		LocalDateTime today = LocalDateTime.now();
		String todayStr = today.format(DateTimeFormatter.ofPattern("yyyyMMddHHmmss"));
		String fileName = "pigeon_"+todayStr+".jpg";
		
		File copyImageFile = new File("C:/Users/rlaeh/eclipse-workspace/day20210508/src/day20210508/fileEx01" , fileName);

//		// 파일에 파일 인풋스트림 연결
//		FileInputStream fin = new FileInputStream(oriImageFile);
//		// 인풋스트림을 버퍼드 인풋스트림에 연결
//		BufferedInputStream bin = new BufferedInputStream(fin);
		
		try(BufferedInputStream bin = new BufferedInputStream(new FileInputStream(oriImageFile));
			BufferedOutputStream bout = new BufferedOutputStream(new FileOutputStream(copyImageFile))){
			
			byte[] buf = new byte[1024];
			
			int len = 0;
			while( bin.available() > 0 ) {
				len = bin.read(buf , 0, buf.length);
				bout.write(buf, 0, len);
				
				// 버퍼드 스트림 안쪽에 있는 버퍼워를 비워주는 메서드를 호출해야한다.
				bout.flush(); // bufferedOutputStream 이 close 될때도 호출된다.
				
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
