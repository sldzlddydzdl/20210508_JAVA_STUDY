package day20210508.fileEx01;

import java.beans.Encoder;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class DataIOStreamTest {
	public static void main(String[] args) {
		
		 try(DataOutputStream dout = new DataOutputStream(
			new FileOutputStream("src/day20210508/fileEx01/99dan.txt"))){ 
			
			String str = "";
			
			for(int i = 2 ; i <= 9; i++) {
				dout.writeUTF("----------"+i+"단"+"----------");
				for(int j = 1 ; j <= 9; j++) {
					str = i+"*"+j +" = "+ (i*j) +"\n";
					dout.writeUTF(str);
				}
			}
			
			dout.flush();
			
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		  try(DataOutputStream dout = new DataOutputStream(
				new FileOutputStream("src/day20210508/fileEx01/lotto.txt"))){
		  
			  dout.writeUTF("로또 번호 : ");
			  
			  int num = 0;
			  for(int i = 0 ; i < 6; i++) {
				  num = (int)(Math.random()*45)+1;
		//			System.out.println(num);
					
				  dout.writeInt(num);
			  }
			  
			  dout.flush();
		  
		  } catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		  } catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		  }
		
	  	System.out.println("--------------구구단 파일----------------");
		try(DataInputStream din = new DataInputStream(
			new FileInputStream("src/day20210508/fileEx01/99dan.txt"))){
			
			while(din.available() > 0) {
				System.out.println(din.readUTF());
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("------------------- 로또 파일 -------------------");
		try(DataInputStream din = new DataInputStream(
			new FileInputStream("src/day20210508/fileEx01/lotto.txt"))){
			
			System.out.print(din.readUTF() + " ");
			while(din.available() > 0) {
				System.out.print(din.readInt() + " ");
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
