import javax.swing.JFrame;
import javax.swing.JLabel;

public class Create 
{   JFrame  f;
	public Create(){
		  f=new JFrame("This is new ");
		JLabel label=new JLabel("This is Good");
		label.setBounds(50, 50,100,50);
		f.add(label);
		
		 f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
		f.setLayout(null);
		f.setSize(500, 500);
	}
    public static void main(String[]args)
    {
    	new Create();
    }
}
