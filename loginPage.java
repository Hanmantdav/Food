import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class loginPage extends JFrame {
private JTextField usernameField;
private JPasswordField passwordField;
public loginPage() {
setTitle("Login Page");
setSize(300, 150);
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
JPanel panel = new JPanel();
add(panel);
placeComponents(panel);
setVisible(true);
}
private void placeComponents(JPanel panel) {
panel.setLayout(null);
JLabel userLabel = new JLabel("Username:");
userLabel.setBounds(10, 20, 80, 25);
panel.add(userLabel);
usernameField = new JTextField(20);
usernameField.setBounds(100, 20, 165, 25);
panel.add(usernameField);
JLabel passwordLabel = new JLabel("Password:");
passwordLabel.setBounds(10, 50, 80, 25);
panel.add(passwordLabel);
passwordField = new JPasswordField(20);
passwordField.setBounds(100, 50, 165, 25);
panel.add(passwordField);
JButton loginButton = new JButton("Login");
loginButton.setBounds(10, 80, 80, 25);
panel.add(loginButton);
loginButton.addActionListener(new ActionListener() {
@Override
public void actionPerformed(ActionEvent e) {
String username = usernameField.getText();
String password = new String(passwordField.getPassword());
// Perform authentication logic here
if (username.equals("yourUsername") && password.equals("yourPassword")) {
JOptionPane.showMessageDialog(null, "Login successful!");
} else {
JOptionPane.showMessageDialog(null, "Invalid username or password");
}
}
});
}
public static void main(String[] args) {
new loginPage();
}
}