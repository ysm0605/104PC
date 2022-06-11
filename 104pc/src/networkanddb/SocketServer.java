package networkanddb;

import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;

import manage_조오연_양수민.ManageForm;

public class SocketServer extends Thread{
	Socket socket;
	private ObjectInputStream ois;
	private ObjectOutputStream oos;
	private SocketEvent event;
	private ManageForm mf;
	private String address;
	
	public SocketServer(Socket socket, ManageForm mf) {
		this.socket = socket;
		this.mf = mf;
		address = socket.getInetAddress().getHostAddress();
	}
	
	@Override
	public void run() {
		try {
			while(true) {
				InputStream is = socket.getInputStream();
				OutputStream os = socket.getOutputStream();
				if (ois == null) {
					ois = new ObjectInputStream(is);
				}
				if (oos == null) {
					oos = new ObjectOutputStream(os);
				}
			
				SocketEvent event = (SocketEvent) ois.readObject();
				EventListener(event);
			}
			
		} catch (EOFException e) {
			// 읽을 데이터가 없다면
			System.out.println("logout 완료");
			mf.setlogout(address);
			return;
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
			HashMap<String, String> data = event.getData();
			
			if (eventName.equals("login")) {
				event.setName("loginSuccess");
				mf.setlogin(socket.getInetAddress().getHostAddress(), event.getData().get("id"));
				oos.writeObject(event);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
