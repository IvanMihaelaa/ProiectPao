package GUI;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.JOptionPane;

public class client {
	
	
	public static void main(String[] args) throws UnknownHostException, IOException, ClassNotFoundException
	{
		
		Interfata i=new Interfata();
		Socket s = new Socket("localhost", 12345);
		ObjectInputStream ois=new ObjectInputStream(s.getInputStream());
		int t=i.getVar();
		System.out.println(t);//il afiseaza
		ObjectOutputStream oos = new ObjectOutputStream(s.getOutputStream());
		oos.writeObject(t);
		
		String mesaj=(String)ois.readObject();//variabila rezultat 
		System.out.println(mesaj);//il afiseaza
		if(t==1)
		     JOptionPane.showMessageDialog(null,mesaj);
		
		oos.close();
		ois.close();
		
	}

}
