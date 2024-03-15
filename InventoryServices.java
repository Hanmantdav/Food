package services;

import java.sql.SQLException;
import java.util.List;

import dao.InventoryDao;

import dto.InventoryDTO;


public class InventoryServices 
{
	public String createRecord(InventoryDTO InventoryDto) {
		InventoryDao createInventoryDao = new InventoryDao();
		try {
			return createInventoryDao.createRecord(InventoryDto);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		return "";
	}
	public List<InventoryDTO> getAllRecord(){
		InventoryDao inventoryDao=new InventoryDao();
		try {
			return inventoryDao.getAllRecord();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	}
	public String updateRecord(InventoryDTO InventoryDto) {
		InventoryDao updateInventoryDao = new InventoryDao();
		try {
			return updateInventoryDao.updateRecord(InventoryDto);
		}
		catch(SQLException e){
			e.printStackTrace();
		}
	
  
	return "";
	
	}
	public String deleteRecord(int customerid) {
		InventoryDao deleteInventoryRecord=new InventoryDao();
		try {
			return deleteInventoryRecord.deleteRecord(customerid);
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		
		
		
		return null;
	}
}