import java.awt.Font;

import javax.swing.*;
public class CreatUserAccount 
{
	public static void main(String[]args)
	{   new CreatUserAccount() ;
		JFrame f=new JFrame("CreateAccount");
		f.setVisible(true);
		f.setLayout(null);
		f.setSize(500, 500);
		
		JLabel l=new JLabel("Create_Username:");
		l.setBounds(420,262,300,100);
		l.setFont(new Font("Arial",Font.BOLD,17));
		
		final JTextField f1=new JTextField();
		f1.setBounds(575, 300, 170, 30);
		f1.setFont(new Font("Arial",Font.PLAIN,17));
		
		JLabel l2=new JLabel("Create_Password:");
		l2.setBounds(420,313,300,100);
		l2.setFont(new Font("Arial",Font.BOLD,17));
		
		final JTextField f2=new JTextField();
		f2.setBounds(575, 350, 170, 30);
		f2.setFont(new Font("Arial",Font.PLAIN,17));
		
		JLabel l3=new JLabel("Confirm_Password:");
		l3.setBounds(410,361,300,100);
		l3.setFont(new Font("Arial",Font.BOLD,17));
		
		JPasswordField f3=new JPasswordField();
		f3.setBounds(575, 400,170,30);
		
		JButton b=new JButton("Create");
		b.setBounds(575, 450, 100, 30); 
		b.setFont(new Font("Arial",Font.BOLD,17));
		
		
		
		f.add(f1);
		f.add(l);
		f.add(f2);
		f.add(l2);
		f.add(f3);
		f.add(l3);
		f.add(b);
	}

}
