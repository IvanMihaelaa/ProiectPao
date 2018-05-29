package bazeDeDate;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.Random;

import javax.swing.JOptionPane;

import date.Vehicul;

public class Main {

	final String DB_URL = "jdbc:mysql://localhost:3306/birou_inmatriculari";
    final String DB_USER = "root";//username;
    final String DB_PASS = "";//password
	public int VerificareNumar(int nr_inreg) throws ClassNotFoundException
	{
		
        Class.forName("com.mysql.cj.jdbc.Driver");//incarcarea 
        int gasit=0;
        
        try(   java.sql.Connection myConn = java.sql.DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
        		PreparedStatement ps = myConn.prepareStatement("SELECT * FROM Vehicule WHERE nr_inregistrare=?");
        		)
        {
        	
        	ps.setInt(1, nr_inreg);
        	try(ResultSet rs = ps.executeQuery();)
        	{
        		while(rs.next())
        	
  			     {
                 gasit++;
  			
  		         }
        	}
        	
        }
        catch( SQLException e)
	    {
	        	e.printStackTrace();
	    } 
        
        return gasit;
	}
	
	public void editeazaProprietar(String nr_inmat,String nume_nou,String prenume, String cnp) throws ClassNotFoundException
	{
		 Class.forName("com.mysql.cj.jdbc.Driver");//incarcarea 
		  try(   java.sql.Connection myConn = java.sql.DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
	        		PreparedStatement ps = myConn.prepareStatement("UPDATE Vehicule SET nume_proprietar=?, prenume_proprietar=?, CNP=? WHERE nr_inmatriculare=?");
	        		)
	        {
	        	ps.setString(1, nume_nou);
	        	ps.setString(2, prenume);
	        	ps.setString(3, cnp);
	        	ps.setString(4, nr_inmat);
	        	ps.executeUpdate();
	        	
	        }
	        catch( SQLException e)
		    {
		        	e.printStackTrace();
		    } 
	}
	
	public void editeazaSerie(String nr_inmat,String serie) throws ClassNotFoundException
	{
		 Class.forName("com.mysql.cj.jdbc.Driver");//incarcarea 
		  try(   java.sql.Connection myConn = java.sql.DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
	        		PreparedStatement ps = myConn.prepareStatement("UPDATE Vehicule SET serie_sasiu=? WHERE nr_inmatriculare=?");
	        		)
	        {
	        	ps.setString(1,serie);
	        	ps.setString(2,nr_inmat);
	        	ps.executeUpdate();
	        	
	        }
	        catch( SQLException e)
		    {
		        	e.printStackTrace();
		    } 
	       	
	}
	
	public void editeazaPutere(String nr_inmat,int p) throws ClassNotFoundException
	{
		 Class.forName("com.mysql.cj.jdbc.Driver");//incarcarea 
		  try(   java.sql.Connection myConn = java.sql.DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
	        		PreparedStatement ps = myConn.prepareStatement("UPDATE Vehicule SET putere=? WHERE nr_inmatriculare=?");
	        		)
	        {
	        	ps.setInt(1,p);
	        	ps.setString(2,nr_inmat);
	        	ps.executeUpdate();
	        	
	        }
	        catch( SQLException e)
		    {
		        	e.printStackTrace();
		    } 
	       	
	}
	
	public void editeazaCapacitate(String nr_inmat,int c) throws ClassNotFoundException
	{
		 Class.forName("com.mysql.cj.jdbc.Driver");//incarcarea 
		  try(   java.sql.Connection myConn = java.sql.DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
	        		PreparedStatement ps = myConn.prepareStatement("UPDATE Vehicule SET capacitate_cilindrica=? WHERE nr_inmatriculare=?");
	        		)
	        {
	        	ps.setInt(1,c);
	        	ps.setString(2,nr_inmat);
	        	ps.executeUpdate();
	        	
	        }
	        catch( SQLException e)
		    {
		        	e.printStackTrace();
		    } 
	       	
	}
	
	public void editeazaStare(String nr_inmat,String stare) throws ClassNotFoundException
	{
		 Class.forName("com.mysql.cj.jdbc.Driver");//incarcarea 
		  try(   java.sql.Connection myConn = java.sql.DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
	        		PreparedStatement ps = myConn.prepareStatement("UPDATE Vehicule SET stare_vehicul=? WHERE nr_inmatriculare=?");
	        		)
	        {
	        	ps.setString(1,stare);
	        	ps.setString(2,nr_inmat);
	        	ps.executeUpdate();
	        	
	        }
	        catch( SQLException e)
		    {
		        	e.printStackTrace();
		    } 
	       	
	}
	
	public int VerificareNumarInmatriculare(String nr_inmat) throws ClassNotFoundException
	{
		
        Class.forName("com.mysql.cj.jdbc.Driver");//incarcarea 
        int gasit=0;
        
        try(   java.sql.Connection myConn = java.sql.DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
        		PreparedStatement ps = myConn.prepareStatement("SELECT * FROM Vehicule WHERE nr_inmatriculare=?");
        		)
        {
        	
        	ps.setString(1, nr_inmat);
        	try(ResultSet rs = ps.executeQuery();)
        	{
        		while(rs.next())
        	
  			     {
                 gasit++;
  			
  		         }
        	}
        	
        }
        catch( SQLException e)
	    {
	        	e.printStackTrace();
	    } 
        
        return gasit;
	}
	
	public int inserare(String nr, String serie, int p, int c, String nume, String prenume, String CNP, String tip, String stare )
	{
		int ok=0;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}//incarcarea 
        
        try(   java.sql.Connection myConn = java.sql.DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
        		PreparedStatement ps = myConn.prepareStatement("INSERT INTO Vehicule"+"(nr_inregistrare,nr_inmatriculare,serie_sasiu,putere,capacitate_cilindrica,nume_proprietar,prenume_proprietar,CNP,data_inregistrarii,tip_vehicul,stare_vehicul)VALUES"+"(?,?,?,?,?,?,?,?,?,?,?)");
        		)
        {
        	Random r=new Random();
			int x=r.nextInt();
			Main m=new Main();
			while(m.VerificareNumar(x)==1)//verifica daca nr de inregistrare exista deja in baza de date
			{
				 r=new Random();
    			 x=r.nextInt();
			}
        	ps.setInt(1,x);
        	ps.setString(2,nr);
        	ps.setString(3, serie);
        	ps.setInt(4,p);
        	ps.setInt(5,c);
        	ps.setString(6,nume);
        	ps.setString(7,prenume);
        	ps.setString(8,CNP);
        	ps.setDate(9, java.sql.Date.valueOf(java.time.LocalDate.now()));
        	ps.setString(10,tip);
        	ps.setString(11,stare);
        	ps.executeUpdate();
        	if(ps!=null)
        		ok=1;
        	
        }
        catch( SQLException e)
	    {
	        	e.printStackTrace();
	    }
        catch (ClassNotFoundException e) 
        {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return ok;
	}
	
	public String verificaNumar(String nrInm)
	{
		String afisare=new String("\n");
		String detalii=new String("");
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}//incarcarea 
        
        try(   java.sql.Connection myConn = java.sql.DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
        		PreparedStatement ps = myConn.prepareStatement("SELECT nr_inmatriculare, stare_vehicul, data_inregistrarii, nume_proprietar FROM Vehicule WHERE nr_inmatriculare=?");
        		)
        {
        	ps.setString(1,nrInm);
        	try(ResultSet rs = ps.executeQuery();)
			{
        		int gasit=0;
        		String nr;
        		Vehicul[] v=new Vehicul[10];
        		while(rs.next())
        		{
        			gasit++;
        			nr= rs.getString("nr_inmatriculare");
        			String raport=rs.getString("stare_vehicul");
        			Date data=rs.getDate("data_inregistrarii");
        			v[gasit]=new Vehicul();
        			v[gasit].setNrInmatriculare(nr);
        			v[gasit].setD((java.sql.Date) data);
        			v[gasit].setRaport(raport);
        			detalii+="De la data: ";
        			detalii+=v[gasit].getD();
        			detalii+=" starea: ";
        			detalii+=v[gasit].getRaport();
        			detalii+="\n";
        			
        		}
        		if(gasit==0)
	        	    afisare+="Nu exista acest numar de inmatriculare";
        		else
        			if(gasit>0)
        			{
        			              afisare+="Detalii despre nr introdus:\n";
        			              afisare+=detalii;
        			}
			}
        	
        }
        catch( SQLException e)
	    {
	        	e.printStackTrace();
	    } 
        
        return afisare;
	}
	
	public void radiaza(String nrInm)
	{
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}//incarcarea 
        
        try(   java.sql.Connection myConn = java.sql.DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
        		PreparedStatement ps = myConn.prepareStatement("SELECT * FROM Vehicule WHERE nr_inmatriculare=?");
        		)
        
        {
        	ps.setString(1,nrInm);
        	try(ResultSet rs = ps.executeQuery();)
			{
        		int gasit=0;
        		String nrInmat,serie,nume,prenume,cnp,tip;
        		int putere,capacitate;
        		while(rs.next())
        		{
        			gasit++;
        			nrInmat=rs.getString(2);
        			serie=rs.getString(3);
        			putere=rs.getInt(4);
        			capacitate=rs.getInt(5);
        			nume=rs.getString(6);
        		    prenume=rs.getString(7);
        			cnp=rs.getString(8);
        			tip=rs.getString(10);
        
        			if(gasit>=1)//daca am gasit o inregistrare imi este d ajuns sa memorez datele de la ea
        				{
    	        			PreparedStatement ps2 = myConn.prepareStatement("INSERT INTO Vehicule"+"(nr_inregistrare,nr_inmatriculare,serie_sasiu,putere,capacitate_cilindrica,nume_proprietar,prenume_proprietar,CNP,data_inregistrarii,tip_vehicul,stare_vehicul)VALUES"+"(?,?,?,?,?,?,?,?,?,?,?)");
    	        			Random r=new Random();
    	        			int x=r.nextInt();
    	        			Main m=new Main();
    	        			while(m.VerificareNumar(x)==1)
    	        			{
    	        				 r=new Random();
	    	        			 x=r.nextInt();
    	        			}
    	        			System.out.println(x);
    	        			
    	        		    ps2.setInt(1,x);
    	        		    ps2.setString(2,nrInmat);
    	    	        	ps2.setString(3,serie);
    	    	        	ps2.setInt(4,putere);
    	    	        	ps2.setInt(5,capacitate);
    	    	        	ps2.setString(6,nume);
    	    	        	ps2.setString(7,prenume);
    	    	        	ps2.setString(8,cnp);
    	    	        	ps2.setDate(9, java.sql.Date.valueOf(java.time.LocalDate.now()));
    	    	        	ps2.setString(10,tip);
    	    	        	String stare=new String("radiat");
    	    	        	ps2.setString(11,stare);
    	    	        	ps2.executeUpdate();
    	    	        	//inchid resursa ps2
    	        			ps2.close();
    	        	        break;
    	        	        
        				}
        		}
        		if(gasit==0)
        			JOptionPane.showMessageDialog(null,"Nu exista acest numar de inmatriculare");
        		
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
           	
        }
        catch( SQLException e)
	    {
	        	e.printStackTrace();
	    } 
	}
	
	
}
