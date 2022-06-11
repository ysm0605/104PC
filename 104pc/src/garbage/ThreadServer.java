package garbage;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

import manage_조오연_양수민.ManageForm;


public class ThreadServer extends Thread {
	private ServerSocket server_socket = null;
	private Socket socket = null;
	
	private ArrayList<ThreadServer> list;
	private BufferedReader in = null;
	private BufferedWriter out = null;
	private ManageForm mf;

	
	public ThreadServer(ManageForm mf) {
		// TODO Auto-generated constructor stub
		try {
			server_socket = new ServerSocket(55555);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.mf = mf;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true) {
        	try {
        		socket = server_socket.accept(); // 서버를 생성, Client는 접속 대기
        		in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        		System.out.println("연결됬음");
        		mf.setlogin(socket.getInetAddress().getHostAddress(), "gumci");
        		System.out.println(socket.getInetAddress().getHostAddress());
        		String inmessage = in.readLine();
        		//if(inmessage.equalsIgnoreCase(socket.getInetAddress().getHostAddress())) {
        			//setlogout(socket.getInetAddress().getHostAddress());
        			//}
            	}
        	catch (Exception e) {
        		e.printStackTrace();
        		System.out.println("while 안에 trycatch 끝에 오나");
				}
        	finally {
        		try {
					in.close();
	        		socket.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				
        		System.out.println("finally 에 오나");
        	}
       
        }
		}
	}



	private void sendToAllClients(String outMsg) {
		// TODO Auto-generated method stub
		for (ThreadServer ts : list) {
			try {
				ts.out.write(outMsg + "\n");
				ts.out.flush();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
