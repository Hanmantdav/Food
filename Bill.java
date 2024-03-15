import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.print.PrinterException;
import java.time.LocalDate;
import java.time.LocalDate.*;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Bill {
    

    
    void openSecondFrame(String value,String value1, String value2,String Value3,String Value4,String Value5) {
        JFrame secondFrame = new JFrame("Second Frame");
        secondFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
       
        JTextArea textArea = new JTextArea(20,38);
        textArea.setFont(new Font("Arial",Font.PLAIN,19));
        LocalDate cure=LocalDate.now();
        LocalTime ti=LocalTime.now();
      DateTimeFormatter format=DateTimeFormatter.ofPattern("hh:mm:ss");
      String formatTime=ti.format(format);
        textArea.append("                                                         BILL\n");
        textArea.append("                                                                                           Date:"+cure.toString()+"\n");
        textArea.append("                                                                                           Time:"+formatTime.toString()+"\n");
        
        textArea.append("customerID:"+"\t      "+value+"\n");
//        textArea.append("\n");
        textArea.append("customerName:"+"          "+value1+"\n");
        textArea.append("\n");
        textArea.append("=======================================================\n");
        
        textArea.append("Fruit:"+"\t                  "+value2+"\n");
        textArea.append("\n");
        textArea.append("\n");
        
        // You can add your bill content here, for example:
        textArea.append("Quantity:"+"\t                  "+Value3+"\n");
        textArea.append("\n");
        textArea.append("\n");
        textArea.append("Price:"+"\t                  "+Value4+"\n");
    
        textArea.append("=======================================================\n");
        textArea.append(String.format("Total:"+"\t                  "+Value5+"\n"));
        textArea.append("\n");
//        textArea.append("                                               "+"Thank You");
        textArea.disable();
        textArea.setDisabledTextColor(Color.black);
//        LocalDate cure=LocalDate.now();
//        textArea.append(""+"\nDate:"+cure.toString()+"\n");
//        LocalTime ti=LocalTime.now();
//        DateTimeFormatter format=DateTimeFormatter.ofPattern("hh:mm:ss");
//        String formatTime=ti.format(format);
//        
//        
//        textArea.append("Time:"+"  "+formatTime.toString()+"\n");
        JPanel panel = new JPanel();
        panel.add(new JScrollPane(textArea));
        JButton bi=new JButton("Print");
        bi.setFont(new Font("Arial",Font.PLAIN,18));
        bi.addActionListener(new ActionListener()
        		{

					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						try {
							textArea.print();
						} catch (PrinterException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
        	
        		});
        
        panel.add(bi);
        secondFrame.add(panel);
        secondFrame.pack();
        secondFrame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new Bill();
            }
        });
    }
}