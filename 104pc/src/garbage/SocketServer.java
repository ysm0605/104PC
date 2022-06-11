package garbage;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;

import manage_조오연_양수민.ManageForm;
import networkanddb.SocketEvent;

public class SocketServer extends Thread {
	ObjectInputStream ois;
	ObjectOutputStream oos;
	
	public SocketServer(ManageForm mf) {
		
	}
	
	@Override
	public void run() {
		try {
			ServerSocket serverSocket = new ServerSocket(55555);
			System.out.println("서버 가동");
			Socket socket = serverSocket.accept();
			System.out.println("클라이언트 연결: " + socket.getInetAddress());
			
			InputStream is = socket.getInputStream();
			OutputStream os = socket.getOutputStream();
			ois = new ObjectInputStream(is);
			oos = new ObjectOutputStream(os);
			
			SocketEvent event = (SocketEvent) ois.readObject();
			EventListener(event);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public void EventListener(SocketEvent event) {
		try {
			String eventName = event.getName();
			System.out.println("이벤트 감지");
			System.out.println("이벤트 이름: " + eventName);
			
			if (eventName.equals("login")) {
				SocketEvent socketEvent = new SocketEvent();
				HashMap<String, String> data = new HashMap<String, String>();
				data.put("id", "sex");
				
				socketEvent.setName("loginSuccess");
				socketEvent.setData(data);
				
				oos.writeObject(socketEvent);
				System.out.println(socketEvent.getData().get("id"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
