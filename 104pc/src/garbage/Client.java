package garbage;

import java.io.*; // java.io 하위 모든 라이브러리 자동 호출
import java.net.*;// java.net 하위 모든 라이브러리 자동 호출
import java.util.Scanner;

public class Client {
	private static BufferedReader in;
	private static BufferedWriter out;

	/*
	 * Java Socket Programming 설명 참조 : https://lktprogrammer.tistory.com/62
	 * InetAddress 설명 참조 : https://hyunssssss.tistory.com/243
	 */
	public static void main(String[] args) {
		Socket socket = null; // Server와 통신하기 위한 Client의 Socket
		Scanner sc = new Scanner(System.in);
		try {
			socket = new Socket("localhost", 55555);
			
			out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
			
			while(true) {
				
				String inMessage = sc.nextLine();
				
				String[] spilt = inMessage.split("#");
				
				if(inMessage.equalsIgnoreCase("bye")) {
					out.write(socket.getInetAddress().getHostAddress());
					break;
				}
				
			}
		}catch(IOException e) {
			e.printStackTrace();
		}finally {
			try {
				out.close();
				socket.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}