package networkanddb;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.HashMap;

import manage_조오연_양수민.ManageForm;
import login_양수민_강현구.login;

public class SocketClient extends Thread {
	ObjectOutputStream oos;
	ObjectInputStream ois;
	Socket socket;
	InputStream is;
	OutputStream os;
	String id;
	Boolean isLogout = false;
	
	public SocketClient(String id) {
		this.id = id;
	}
	@Override
	public void run() {
		try {
			while(!isLogout) {
				socket = new Socket("localhost", 55555);
				
				is = socket.getInputStream();
				os = socket.getOutputStream();
				
				if (oos == null) {
					oos = new ObjectOutputStream(os);
				}
				if (ois == null) {
					ois = new ObjectInputStream(is);
					this.Login();
				}
				
				SocketEvent event = (SocketEvent) ois.readObject();
				System.out.println("이벤트 수신: " + event.getName());
			}
			
		}catch (SocketException e) {
			System.out.println("로그아웃");
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public void Login() {
		try {
			SocketEvent event = new SocketEvent();
			HashMap<String, String> data = new HashMap<String, String>();
			data.put("id", id);
			
			event.setName("login");
			event.setData(data);
			
			System.out.println("이벤트 이름 : " + event);
			oos.writeObject(event);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void logout() {
		try {
			isLogout = true;
//			SocketEvent event = new SocketEvent();
//			event.setName("logout");
			//oos.writeObject(event);
			
			socket.close();
			is.close();
			os.close();
			
			oos.close();
			ois.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
