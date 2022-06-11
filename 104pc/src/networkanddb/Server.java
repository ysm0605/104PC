package networkanddb;

import java.io.*;
import java.net.*;
import java.nio.*;
import java.util.ArrayList;

import manage_조오연_양수민.ManageForm;

public class Server extends Thread{
	Socket socket = null;
    ServerSocket server_socket = null;
    private ArrayList<SocketServer> list = new ArrayList<>();
    ManageForm mf;
    
    public Server(ManageForm mf) {
    	this.mf = mf;
    }
    
    @Override
    public void run() {
		try {
			server_socket = new ServerSocket(55555);
            System.out.println("서버가 열렸습니다.");
            while(true) {
            	System.out.println("요청을 대기합니다.");
            	socket = server_socket.accept(); // 서버를 생성, Client는 접속 대기
            	System.out.println(socket.getInetAddress() + "로부터 요청을 받았습니다.");
            	SocketServer st = new SocketServer(socket, mf);
            	st.start();
            	list.add(st);
            }
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}