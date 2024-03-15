import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
public class exp {
	public static void main(String[]a)
	{
		new exp();
	}

	exp(){
		
		JFrame f=new JFrame("Print");
		f.setVisible(true);
		JLabel l = new JLabel("Customer Name");
		l.setBounds(0, 100, 150, 50);
		l.setFont(new Font("Arial",Font.BOLD,18));
		JButton back=new JButton("Back");
		back.setFont(new Font("Arial",Font.BOLD,20));
		back.setBounds(1190, 50,110,30);
		back.addActionListener(new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				l.setText("Sexl");
			}

		});

		
		f.add(l);
		f.add(back);
		f.setLayout(null);
	
	}
}