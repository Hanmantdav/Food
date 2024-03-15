import java.awt.Font;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import dto.UserDTO;
import services.UserService;

public class Cons {
	
	JFrame f;
	Cons() {
		f = new JFrame();

		f.setBounds(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
		f.setLayout(null);

		JLabel userNameLabel = new JLabel("Create Username:");
		userNameLabel.setBounds(420, 262, 300, 100);
		userNameLabel.setFont(new Font("Arial", Font.BOLD, 17));

		final JTextField userNameText = new JTextField();
		userNameText.setBounds(575, 300, 170, 30);
		userNameText.setFont(new Font("Arial", Font.PLAIN, 17));

		JLabel createPwdLbl = new JLabel("Create Password:");
		createPwdLbl.setBounds(420, 313, 300, 100);
		createPwdLbl.setFont(new Font("Arial", Font.BOLD, 17));

		final JPasswordField createPwd = new JPasswordField();
		createPwd.setBounds(575, 350, 170, 30);
		createPwd.setFont(new Font("Arial", Font.PLAIN, 17));

		JLabel createPwdLbl1 = new JLabel("Confirm Password:");
		createPwdLbl1.setBounds(410, 361, 300, 100);
		createPwdLbl1.setFont(new Font("Arial", Font.BOLD, 17));

		JTextField createPwd1 = new JTextField();
		createPwd1.setBounds(575, 400, 170, 30);

		JButton createUserBtn = new JButton("Create");
		createUserBtn.setBounds(575, 450, 100, 30);
		createUserBtn.setFont(new Font("Arial", Font.BOLD, 17));

		createUserBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				UserDTO userDTO = new UserDTO();
				userDTO.setUserName(userNameText.getText());
				userDTO.setPassword(createPwd.getPassword().toString());
				UserService createUserService = new UserService();
				String saveMessage = createUserService.createUser(userDTO);
				if (saveMessage.equals("successful")) {
					 JOptionPane.showMessageDialog(null, "User Created Successful");
				}

			}
		});
		createPwd1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				if(createPwd.getPassword().toString().equals(createPwd1.getText())) {
					System.out.println("password matched");
				}else {
					System.out.println("password does not match");
				}
			}
		});
		f.add(userNameText);
		f.add(userNameLabel);
		f.add(createPwd);
		f.add(createPwdLbl);
		f.add(createPwd1);
		f.add(createPwdLbl1);
		f.add(createUserBtn);

		f.setVisible(true);
	}

	public static void main(String[] args) {

		new Cons();
	}

}
