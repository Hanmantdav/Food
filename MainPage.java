import java.awt.Color;
import java.awt.Color.*;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.GregorianCalendar;
import java.util.List;
import java.awt.print.*;
import java.sql.Date;
import java.text.NumberFormat;

import javafx.print.*;
import org.jdatepicker.*;
import org.jdatepicker.UtilDateModel;
import java.util.Properties;
import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import com.mysql.cj.protocol.a.UtilDateValueEncoder;

import dto.InventoryDTO;

import services.InventoryServices;

public class MainPage {
	public static void main(String[] args) {
		new MainPage();
	}
	private int cuid;
	MainPage() {
		
		JFrame f = new JFrame("Inventery managment");
		f.setLayout(null);
	
     
		f.setBounds(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
		f.setResizable(true);

		JLabel  valii=new JLabel();
		valii.setFont(new Font("Arial",Font.BOLD,13));
		valii.setBounds(10, 60, 150, 50);
		valii.setForeground(Color.red);
		
		JLabel l = new JLabel("Customer Name");
		l.setBounds(0, 40, 150, 50);
		l.setFont(new Font("Arial",Font.BOLD,18));
		final JTextField customername = new JTextField();
		customername.setBounds(149, 50, 230, 30);
		customername.setFont(new Font("Arial",Font.PLAIN,18));
		
		customername.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				try {
			    	String i=customername.getText();
			    	valii.setText("");
			    }
			    catch(Exception we) {
			    valii.setText("Please Enter Alphabet.");
		     	}
			}
			public void keyTyped(KeyEvent s) {
				char a=s.getKeyChar();
				if(Character.isDigit(a)) {
					s.consume();
			       		
				}
				else {
					
				}
				
			}
			});
		JLabel fruit=new JLabel("Select Fruit");
		fruit.setFont(new Font("Arial",Font.BOLD,18));
		fruit.setBounds(390, 40, 150, 50);
           		
		String lan[] = { "Grapes", "Apple", "Oranges", "kiwi", "Banana", "Dragon Fruit", "Carrot" };
		final JComboBox<Object> cb = new JComboBox<Object>(lan);
		cb.setBounds(500, 50, 100, 32);
		
		JLabel date1=new JLabel("Date");
		date1.setFont(new Font("Arial",Font.BOLD,18));
		date1.setBounds(620,40,150,50);
		

		JDatePicker datePicker=new JDatePicker();
//	    datePicker.setFont(new Font("Arial",Font.BOLD,18));
//	   Date  sel=(Date)datePicker.getModel().getValue();
	   
	    datePicker.setBounds(673, 51, 110, 32);	    
		
		JLabel  TotalPrise=new JLabel("Total");
		TotalPrise.setFont(new Font("Arial",Font.BOLD,20));
		TotalPrise.setBounds(1190, 40, 150, 50);
		JFormattedTextField  total=new JFormattedTextField();
		total.setFont(new Font("Arial",Font.PLAIN,18));
//		total.setForeground(Color.black);;
		total.setBounds(1250, 50,90,30);	
		total.disable();
		total.setDisabledTextColor(Color.black);
		
		JLabel  vali=new JLabel();
		vali.setFont(new Font("Arial",Font.BOLD,13));
		vali.setBounds(790, 60, 150, 50);
		vali.setForeground(Color.red);
		
		JLabel  inval=new JLabel();
		inval.setFont(new Font("Arial",Font.BOLD,13));
		inval.setBounds(890, 60, 150, 50);
		inval.setForeground(Color.red);
		
		JLabel  count=new JLabel("Quantity");
		count.setFont(new Font("Arial",Font.BOLD,18));
		count.setBounds(810, 40, 150, 50);
		JFormattedTextField  num=new JFormattedTextField();
		num.setBounds(895, 50,100,30);	
		num.setFont(new Font("Arial",Font.PLAIN,18));
		num.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				try {
			    	double i=Double.parseDouble(num.getText());
			    	vali.setText("");
			    }
			    catch(Exception we) {
			    vali.setText("Please Enter Number.");
		     	}
			}
			public void keyTyped(KeyEvent s) {
				char a=s.getKeyChar();
				if(!Character.isDigit(a)) {
					s.consume();
			       		
				}
				else {
					
				}
				
			}
			});
		
		
		JLabel  FruitPrise=new JLabel("Price");
		FruitPrise.setFont(new Font("Arial",Font.BOLD,20));
		FruitPrise.setBounds(1020, 40, 150, 50);
		JFormattedTextField  price=new JFormattedTextField();
		price.setFont(new Font("Arial",Font.PLAIN,18));
		price.setBounds(1080, 50,90,30);	
		price.addKeyListener(new KeyAdapter() {
			
			public void keyPressed(KeyEvent e) {
				try {
			    	double i=Double.parseDouble(price.getText());
			    	inval.setText("");
			    }
			    catch(Exception we) {
			    inval.setText("Please Enter Number.");
		     	}
			}
			public void keyTyped(KeyEvent s) {
				char a=s.getKeyChar();
				if(!Character.isDigit(a)) {
					s.consume();
			       		
				}
				else {
					
				}
				
			}
			
			
		});
		num.getDocument().addDocumentListener(new DocumentListener() {

			
//			public void actionPerformed(ActionEvent e) {
//				// TODO Auto-generated method stub
//				double quantityValue=Double.parseDouble(num.getText());
//				double priceValue=Double.parseDouble(price.getText());
//				double totalvalue=quantityValue* priceValue;
//				total.setText(Double.toString(totalvalue));
//			}

			@Override
			public void insertUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				updateTotal();
			}

			@Override
			public void removeUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				updateTotal();
			}

			@Override
			public void changedUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				updateTotal();
			}
			private void updateTotal() {
				cal();
			}

			private void cal() {
				try {
				double quantityValue=Double.parseDouble(num.getText());
				double priceValue=Double.parseDouble(price.getText());
				double totalvalue=quantityValue* priceValue;
				total.setText(Double.toString(totalvalue));
				}
				catch(NumberFormatException e)
				{
//					JOptionPane.showMessageDialog(null, "Please Enter Number..");
				}
			}
			
			
		});
		
	
		
		price.getDocument().addDocumentListener(new DocumentListener() {

//			public void actionPerformed(ActionEvent e) {
//			// TODO Auto-generated method stub
//			double quantityValue=Double.parseDouble(num.getText());
//			double priceValue=Double.parseDouble(price.getText());
//			double totalvalue=quantityValue* priceValue;
//			total.setText(Double.toString(totalvalue));
//		}
			@Override
			public void insertUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				updateTotal();
			}

			@Override
			public void removeUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				updateTotal();
			}

			@Override
			public void changedUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				updateTotal();
			}

			
			private void updateTotal() {
				cal();
			}

			private void cal() {
				try {
					if(num.getText()!=null && price.getText()!=null) {
				double quantityValue=Double.parseDouble(num.getText());
				double priceValue=Double.parseDouble(price.getText());
				double totalvalue=quantityValue* priceValue;
				total.setText(Double.toString(totalvalue));
					}
				}
				catch(NumberFormatException e)
				{
					System.out.println();
					
				}
			}
			
		});
		JFormattedTextField  num1=new JFormattedTextField();
		num1.setBounds(60, 10,100,30);	
		num1.setFont(new Font("Arial",Font.PLAIN,18));
		
		String [][]data= getData();
		String column[]= {"customerid","Customer Name","Fruit","Date","Quantity","Price","Total",};
		DefaultTableModel tableModel=new DefaultTableModel(data,column);
         
		JTable jt=new JTable(tableModel);
		
		
		
		
		jt.addMouseListener(new MouseListener() {
			
			

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				cuid=Integer.parseInt(tableModel.getValueAt(jt.getSelectedRow(), 0).toString());
			   
				String rs=tableModel.getValueAt(jt.getSelectedRow(), 1).toString();
				String fr=tableModel.getValueAt(jt.getSelectedRow(), 2).toString();
//				String da=tableModel.getValueAt(jt.getSelectedRow(),3).toString();
				double ss=Double.parseDouble(tableModel.getValueAt(jt.getSelectedRow(), 4).toString());
						
				double pri=Double.parseDouble(tableModel.getValueAt(jt.getSelectedRow(), 5).toString());
				
				double to=Double.parseDouble(tableModel.getValueAt(jt.getSelectedRow(), 6).toString());
			
				
				customername.setText(rs);
				cb.setSelectedItem(fr);
//				datePicker.setToolTipText(String.valueOf(da));
				num1.setText(String.valueOf(cuid));
				num.setText(String.valueOf(ss));
				price.setText(String.valueOf(pri));
				total.setText(String.valueOf(to));
			}
		});
		
		jt.setRowHeight(30);
		
		
		JButton add=new JButton("Add");
		add.setFont(new Font("Arial",Font.BOLD,20));
		add.setBounds(1190, 100,110,30);
		add.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				InventoryDTO inventoryDTo = new InventoryDTO();
				
				inventoryDTo.setCustomerName(customername.getText());
				inventoryDTo.setFruitName(cb.getSelectedItem().toString());
				inventoryDTo.setDate(((GregorianCalendar) datePicker.getModel().getValue()).getTime());
				inventoryDTo.setPrice(Double.parseDouble(price.getText()));
				inventoryDTo.setQuantity(Double.parseDouble(num.getText()));
				
				inventoryDTo.setTotal(Double.parseDouble(total.getText()));
				
				InventoryServices createInventoryService = new InventoryServices();
				String saveMessage = createInventoryService.createRecord(inventoryDTo);
				if (saveMessage.equals("successful")) 
				{  
					String [][]data= getData();
					String column[]= {"customerid","Customer Name","Fruit","Date","Quantity","Price","Total",""};
					DefaultTableModel tableModel=new DefaultTableModel(data,column);
					
					
					
					jt.setModel(tableModel);
					
					jt.repaint();
					JOptionPane.showMessageDialog(null, "Record Inserted successful..");
				}

				  
			}
		});	
		
	   	InventoryDTO inventoryDto=new InventoryDTO();
	   	
		
		
		DefaultTableCellRenderer  centerRenderer=new  DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment(JLabel.CENTER);
		jt.setDefaultRenderer(Object.class, centerRenderer);
		
		jt.getTableHeader().setFont(new Font("Arial",Font.BOLD,20));
//		jt.setBounds(30, 40, 200, 300);
		jt.setFont(new Font("Arial",Font.BOLD,19));
//		jt.setAlignmentX();
		
//      DefaultTableCellRenderer  centerRenderer=new  DefaultTableCellRenderer();
//		centerRenderer.setHorizontalAlignment(JLabel.CENTER);
//		jt.setDefaultRenderer(String.class, centerRenderer);
		
		JScrollPane sp=new JScrollPane(jt);
		sp.setFont(new Font("Arial",Font.BOLD,30));
		sp.setBounds(10, 120, 1150, 300);
		
		
		JButton update =new JButton("Update");
		update.setBounds(1190, 150, 110, 30);
		update.setFont(new Font("Arial",Font.BOLD,19));
		update.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) 
        {
				// TODO Auto-generated method stub
        	InventoryDTO inventoryDTo = new InventoryDTO();
        	
        	inventoryDTo.setCustomerId(Integer.parseInt(num1.getText()));
			
        	inventoryDTo.setCustomerName(customername.getText());
			inventoryDTo.setFruitName(cb.getSelectedItem().toString());
			inventoryDTo.setDate(((GregorianCalendar) datePicker.getModel().getValue()).getTime());
			inventoryDTo.setPrice(Double.parseDouble(price.getText()));
			inventoryDTo.setQuantity(Double.parseDouble(num.getText()));
			
			inventoryDTo.setTotal(Double.parseDouble(total.getText()));
			
			InventoryServices updateInventoryService = new InventoryServices();
			String saveMessage = updateInventoryService.updateRecord(inventoryDTo);
				
			if (saveMessage.equals("successful")) 
			{
			
				String [][]data= getData();
				String column[]= {"customerid","Customer Name","Fruit","Date","Quantity","Price","Total",""};
				DefaultTableModel tableModel=new DefaultTableModel(data,column);
				
				
				
				jt.setModel(tableModel);
			
				jt.repaint();
			}
			}});
		
		sp.setVisible(true);
		
		JButton delete =new JButton("Delete");
	    delete.setBounds(1190, 250, 110, 30);
	    delete.setFont(new Font("Arial",Font.BOLD,19));
	    delete.addActionListener(new ActionListener() {
	    	
			
			
			
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				InventoryDTO inventoryDTo = new InventoryDTO();
	        	
	        	inventoryDTo.setCustomerId(Integer.parseInt(num1.getText()));
	        	InventoryServices deleteInventoryService = new InventoryServices();
				String saveMessage = deleteInventoryService.deleteRecord(cuid);
				if (saveMessage.equals("successful")) 
				{
				
					String [][]data= getData();
					String column[]= {"customerid","Customer Name","Fruit","Date","Quantity","Price","Total",""};
					DefaultTableModel tableModel=new DefaultTableModel(data,column);
					
					
					
					jt.setModel(tableModel);
				
					jt.repaint();
				}
			}
		});
	  
		JButton print =new JButton("Print");
	    print.setBounds(1190, 310, 110, 30);
	    print.addActionListener(new ActionListener()
	    		{
	    	            
					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						
						Bill obj=new Bill();
						obj.openSecondFrame(num1.getText(),customername.getText(),cb.getSelectedItem().toString(),num.getText(),price.getText(),total.getText());
						
					}
	    	
	    		});

        f.add(l);
//      f.add(b);
        f.add(fruit);
		f.add(customername);
		f.add(cb);

		f.add(sp);
		f.add(add);
		f.add(total);
		f.add(TotalPrise);
		f.add(FruitPrise); 
		f.add(price);
		f.add(num);
		f.add(count);
        f.add(update);
        f.add(print);
//        f.add(num1);
        f.add(delete);
        f.add(vali);
        f.add(inval);
        f.add(valii);
        f.add(datePicker);
        f.add(date1);
        f.setVisible(true);
	}
   public String[][] getData(){
	  InventoryServices inventoryServices=new InventoryServices();
	  List<InventoryDTO> listInventoryDto=inventoryServices.getAllRecord();
	  String[][] data=new String[listInventoryDto.size()][7]; 
	  int i=0,j;
	  for(InventoryDTO iDto:listInventoryDto) {
		  j=0;
		  data[i][j++]=String.valueOf(iDto.getCustomerId());
		  data[i][j++]=iDto.getCustomerName();
		  data[i][j++]=iDto.getFruitName();
		  data[i][j++]=String.valueOf(iDto.getDate());
		  data[i][j++]=String.valueOf(iDto.getQuantity());
		  data[i][j++]=String.valueOf(iDto.getPrice());
		  data[i][j++]=String.valueOf(iDto.getTotal());

        i++;
	  }
	   return data;
	   
   }
}
