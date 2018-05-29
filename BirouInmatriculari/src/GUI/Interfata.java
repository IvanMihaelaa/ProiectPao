package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import bazeDeDate.Main;

public class Interfata {
	
	private  int var;
	
	public  int getVar() {
		return var;
	}

	public void setVar(int var) {
		this.var = var;
	}

	public Interfata()
	{
		
	JFrame frame=new JFrame("Inmatriculari auto");
	JPanel root=new JPanel();
	JPanel panel_01=new JPanel();
	panel_01.setPreferredSize(new Dimension(800,800));
	JLabel text1=new JLabel("Editare date");
	JLabel text2=new JLabel("Verificare");
	JButton adaugare=new JButton("Adugare");
	JButton editare=new JButton("Editare");
	JButton radiere=new JButton("Radiere");
	JButton verificare=new JButton("Verificare");
	
	GridBagConstraints constraints=new GridBagConstraints();
	constraints.fill=GridBagConstraints.NONE;
	constraints.anchor=GridBagConstraints.CENTER;
	panel_01.setLayout(new GridLayout(6,1));
	
	root.setLayout(new GridBagLayout());
	
	panel_01.add(text1);
	panel_01.add(adaugare);
	panel_01.add(editare);
	panel_01.add(radiere);
    panel_01.add(text2);
	panel_01.add(verificare);
	
	frame.setContentPane(root);
	root.add(panel_01,constraints);
	
	
	
	frame.setSize(500, 500);
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.setVisible(true);
	
	JDialog dialog=new JDialog(frame,"Salveaza date",true);
	JDialog dialog2=new JDialog(frame,"Verificare date",true);
	JDialog dialog3=new JDialog(frame,"Radiere",true);
	JDialog dialog4=new JDialog(frame,"Editare",true);
	
	adaugare.addActionListener(new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			
			String nr=JOptionPane.showInputDialog(dialog,"Numar inamtriclare:");
			String serie=JOptionPane.showInputDialog(dialog,"Serie sasiu:");
			String putere=JOptionPane.showInputDialog(dialog,"Putere(KW):");
			String capacitate=JOptionPane.showInputDialog(dialog,"Capacitate cilindrica(cm3):");
			String nume=JOptionPane.showInputDialog(dialog,"Nume proprietar:");
			String prenume=JOptionPane.showInputDialog(dialog,"Prenume proprietar:");
			String CNP=JOptionPane.showInputDialog(dialog,"CNP:");
			String tip=JOptionPane.showInputDialog(dialog,"Tip vehicul:");
			String stare=JOptionPane.showInputDialog(dialog,"Stare vehicul(valid,radiat,furat,gasit):");
		    //dialog.addFieldValue(typeid(NoYesId), NoYes::Yes, "Check");
			
			int p=Integer.parseInt(putere);
			int c=Integer.parseInt(capacitate);
			
			Main m=new Main();
		    int val=m.inserare(nr,serie,p,c,nume,prenume,CNP,tip,stare);
		    var=val;
		
		}});
	
	verificare.addActionListener(new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			
		
			String nrInm=JOptionPane.showInputDialog(dialog2,"Introduceti nr de inmatriculare despre care doriti sa aflati informatii(Litere mari):");
			Main m=new Main();
			
		    String afiseaza=m.verificaNumar(nrInm);
			JOptionPane.showMessageDialog(null,afiseaza);
		}});
	 
	radiere.addActionListener(new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			String nrInm=JOptionPane.showInputDialog(dialog3,"Introduceti nr de inmatriculare pe care doriti sa-l radiati (Litere mari):");
			Main m=new Main();
	        m.radiaza(nrInm);
			
		}});
	
	editare.addActionListener(new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			String nrInm=JOptionPane.showInputDialog(dialog4,"Introduceti nr de inmatriculare pe care doriti sa-l editati (Litere mari):");
	        Main m=new Main();
	        try {
				if(m.VerificareNumarInmatriculare(nrInm)==0)
					JOptionPane.showMessageDialog(null,"Nu exista acest numar");
				else
				{
				String val=JOptionPane.showInputDialog(dialog4,"Alegeti ce doriti sa modificati!!\n1-Modificare serie sasiu\n2-Modificare putere\n3-Modificare capacitate cilindrica\n4-Modificare proprietar\n5-Modificare stare vehicul");
			    int x=Integer.parseInt(val);
				switch(x)
				{
					case 1:JOptionPane.showMessageDialog(null,"Ati ales modficarea seriei sasiului. Pentru a continua apasati OK!");
					       String serie=JOptionPane.showInputDialog(dialog,"Noua serie este:");
					       try {
					    	   m.editeazaSerie(nrInm, serie);
					       } catch (ClassNotFoundException e1) {
					    	   // TODO Auto-generated catch block
					    	   e1.printStackTrace();
					       }
					       break;
					case 2:JOptionPane.showMessageDialog(null,"Ati ales modficarea puterii vehiculului. Pentru a continua apasati OK!");
					       String p=JOptionPane.showInputDialog(dialog,"Noua putere a masinii este:");
					       int v=Integer.parseInt(p);
					       try {
					    	   m.editeazaPutere(nrInm,v);
					       } catch (ClassNotFoundException e1) {
					    	   // TODO Auto-generated catch block
					    	   e1.printStackTrace();
					       }
						   break;
					case 3:JOptionPane.showMessageDialog(null,"Ati ales modficarea capacitatii cilindrice a motorului. Pentru a continua apasati OK!");
					       String cap=JOptionPane.showInputDialog(dialog,"Noua capacitate cilindrica a masinii este:");
					       int c=Integer.parseInt(cap);
					       try {
					    	   m.editeazaCapacitate(nrInm, c);
					       } catch (ClassNotFoundException e1) {
					    	   // TODO Auto-generated catch block
					    	   e1.printStackTrace();
					       }
				           break;
					case 4:JOptionPane.showMessageDialog(null,"Ati ales modficarea datelor proprietarului vehiculului. Pentru a continua apasati OK!");
						   String nume=JOptionPane.showInputDialog(dialog,"Numele noului proprietar:");
					       String prenume=JOptionPane.showInputDialog(dialog,"Prenumele noului proprietar:");
				       	   String CNP=JOptionPane.showInputDialog(dialog,"CNP-ul noului proprietar:");
					       try {
						         m.editeazaProprietar(nrInm,nume,prenume,CNP);
				        	} catch (ClassNotFoundException e) {
					    	// TODO Auto-generated catch block
					     	e.printStackTrace();
					       }
				           break;
					case 5:JOptionPane.showMessageDialog(null,"Ati ales modficarea starii vehiculului. Pentru a continua apasati OK!");
					       String stare_actuala=JOptionPane.showInputDialog(dialog,"Noua stare a masinii este:");
					       try {
					    	   m.editeazaStare(nrInm, stare_actuala);
					       } catch (ClassNotFoundException e) {
					    	   // TODO Auto-generated catch block
					    	   e.printStackTrace();
					       }
					       break;	 
					default:JOptionPane.showInputDialog(dialog4,"Ai ales o varianta gresita! Te rugam sa alegi din nou");
					}

				}
				
			} catch (HeadlessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}});
	}
}
