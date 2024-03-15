import java.awt.Font;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import dto.UserDTO;
import services.UserService;
public class login 
{
	public static void main(String[]args)
	{
		JFrame f=new JFrame("Login Page");
		
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		f.setLayout(null);
		f.setBounds(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
	     
		JLabel l=new JLabel("Username:");
		l.setBounds(472,266,300,100);
		l.setFont(new Font("Arial",Font.BOLD,17));
		
		final JTextField f1=new JTextField();
		f1.setBounds(575, 300, 170, 30);
		f1.setFont(new Font("Arial",Font.PLAIN,16));
		
		JLabel l2=new JLabel("Password:");
		l2.setBounds(472,315,300,100);
		l2.setFont(new Font("Arial",Font.BOLD,17));
		
		JPasswordField p=new JPasswordField();
		p.setBounds(575, 350,170,30);
		
		JButton b=new JButton("Login");
		b.setBounds(640, 400, 100, 30); 
		b.setFont(new Font("Arial",Font.BOLD,17));
		b.addActionListener(new ActionListener() {
           

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(e.getSource()==b)
				{ UserService userService= new UserService();
				UserDTO userDTO = new UserDTO();
				userDTO.setUserName(f1.getText());
				userDTO.setPassword(p.getText());
				 if(userService.userLogin(userDTO).equals("successful")) {
					 MainPage MainPa=new MainPage();
				 }else {
					 JOptionPane.showMessageDialog(null, "Invalid username or password");
				 }
			
				}
			}
			});
		JButton b1=new JButton("Create User");
		b1.setBounds(480, 400, 150, 30); 
		b1.setFont(new Font("Arial",Font.BOLD,17));
		b1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==b1) {
					Cons Con=new Cons();
				}
				
			}
			
		});
		
//		f1.setHorizontalAlignment(JTextField.LEFT);
//		f1.setHorizontalAlignment(JTextField.CENTER);
//		f1.setHorizontalAlignment(JTextField.RIGHT);
		
		f.add(f1);
		f.add(l);
		f.add(p);
		f.add(l2);
		f.add(b);
		f.add(b1);	
		f.setVisible(true);
	}

}
