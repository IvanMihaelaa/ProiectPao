package GUI;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	
	public static void main(String[] args) throws IOException, ClassNotFoundException 
	{
		
		String m=new String("");
		ServerSocket ss = new ServerSocket(12345);
		System.out.println("Conectat");
		
		//ii spunem serverului sa astepte
		Socket socket=ss.accept();
		
		OutputStream os= socket.getOutputStream();
		ObjectOutputStream oos = new ObjectOutputStream(os);
		
		

		InputStream i=socket.getInputStream();
		ObjectInputStream ois=new ObjectInputStream(i);
		int valoare=(int)ois.readObject();
		System.out.println(valoare);
		
		if(valoare==1)
		    m="S-a inserat cu succes!";
		oos.writeObject(m);
		
		ois.close();
		oos.close();
	}

}
