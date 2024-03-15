package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


import dto.InventoryDTO;


public class InventoryDao 
{
	public String createRecord(InventoryDTO InventoryDto) throws SQLException {
		Connection con = null;
		try {
			// Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/inventory", "root", "admin");
			String query = " insert into inventory (customername,fruit,Date,quantity,price,total) values (?, ?, ?, ?, ?, ?)";

			PreparedStatement preparedStmt = con.prepareStatement(query);
//			preparedStmt.setInt(1, InventoryDto.getCustomerId());
			preparedStmt.setString(1, InventoryDto.getCustomerName());
			preparedStmt.setString(2, InventoryDto.getFruitName());
			preparedStmt.setDate(3,new Date( InventoryDto.getDate().getTime()));
			preparedStmt.setDouble(4, InventoryDto.getQuantity());
			preparedStmt.setDouble(5, InventoryDto.getPrice());
			preparedStmt.setDouble(6, InventoryDto.getTotal());
			preparedStmt.execute();

		} catch (Exception e) {
			System.out.println("CreateUserDao | createUser" + e.getMessage());
			return "unsuccessful";
		} finally {
			con.close();
		}
		return "successful";
	}
	public List<InventoryDTO> getAllRecord()throws SQLException{
		Connection con;
		InventoryDTO  inventoryDto=new InventoryDTO();
		
		List<InventoryDTO>  listInventoryDto=new  ArrayList<InventoryDTO>();
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/inventory", "root", "admin");
			String query ="select * from inventory";
			
			
			Statement stmt = con.createStatement();
			
			ResultSet rs=stmt.executeQuery(query);
			while(rs.next())
			{  inventoryDto=new InventoryDTO();
				int id=rs.getInt(1);
			    String name=rs.getString(2);
				String fruit=rs.getString(3);
				Date date=rs.getDate(4);
				double quantity=rs.getDouble(5);
				double price=rs.getDouble(6);
				double total=rs.getDouble(7);
				inventoryDto.setCustomerId(id);
				inventoryDto.setCustomerName(name);
				inventoryDto.setFruitName(fruit);
				inventoryDto.setDate(date);
				inventoryDto.setPrice(price);
				inventoryDto.setQuantity(quantity);
				inventoryDto.setTotal(total);
				listInventoryDto.add(inventoryDto);
			}
			

			
		}
		catch(Exception e)
		{
		
			
		}
		
		return listInventoryDto;
		
	}
	public String updateRecord(InventoryDTO InventoryDto)throws SQLException {
		Connection con = null;
		
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/inventory", "root", "admin");
			String query ="Update inventory set customername=?,fruit=?,Date=?,quantity=?,price=?,total=?  where  customerid=?";
			PreparedStatement preparedStmt = con.prepareStatement(query);
			preparedStmt.setString(1,InventoryDto.getCustomerName());
			preparedStmt.setString(2,InventoryDto.getFruitName());
			preparedStmt.setDate(3, new Date( InventoryDto.getDate().getTime()));
			preparedStmt.setDouble(4, InventoryDto.getQuantity());
			preparedStmt.setDouble(5, InventoryDto.getPrice());
			preparedStmt.setDouble(6, InventoryDto.getTotal());
			preparedStmt.setInt(7, InventoryDto.getCustomerId());
            preparedStmt.executeUpdate();
	
		}
		catch(Exception e) {
			return "unsuccessful";
	}
		return "successful";
	}
	public String deleteRecord(int customerid) throws SQLException{
		Connection con = null;
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/inventory", "root", "admin");
			String query ="delete from inventory where customerid=?";
			PreparedStatement preparedStmt = con.prepareStatement(query);
			preparedStmt.setInt(1, customerid);
			preparedStmt.executeUpdate();
			
		}
		catch(SQLException e)
		{
			return "unsuccessful";
		}
		
	
	return "successful";
	}
	
}