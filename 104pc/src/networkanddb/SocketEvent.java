package networkanddb;

import java.io.Serializable;
import java.util.HashMap;

public class SocketEvent implements Serializable {
	private static final long serialVersionUID = 1L;
	private String name;
	private HashMap<String, String> data;
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public HashMap<String, String> getData() {
		return data;
	}
	
	public void setData(HashMap<String, String> data) {
		this.data = data;
	}
}
