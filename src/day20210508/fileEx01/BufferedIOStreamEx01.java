package day20210508.fileEx01;

import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class BufferedIOStreamEx01 {
	public static void main(String[] args) {
		// 버퍼에 쌓여 글자가 나오지 않는 콬드
		BufferedOutputStream bout = null;
		FileOutputStream fout = null;
		
		try {
			fout = new FileOutputStream("src/day20210508/fileEx01/buff.txt");
			bout = new BufferedOutputStream(fout);
			
			// 버퍼에 기본적으로 8kbyte만큼 쌓인다.
			for(int i = 0 ; i < 1024*8; i++) {
				bout.write('a');
//				bout.flush(); // 이렇게 할수있으나 그러면 BufferedOutputStream을 쓰는 이유가없어진다.
			}
			// flush를 하면 버퍼에 있는 데이터를 파일에 작성한다. 또는 close 될때도
			bout.flush();
//			bout.write('b');
			System.out.println("파일 작성 완료");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
