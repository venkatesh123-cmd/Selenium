package org.tcs.selenium.ReadExcel;

import java.io.File;
import java.io.FileInputStream;
import java.util.HashMap;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.tcs.selenium.LanuchBrower.Utilities.PropertiesLoad;

public class Utility {
	public static void main(String args[]){
		PropertiesLoad SUtil				=	 new PropertiesLoad();
		String dir 							=	 SUtil.getCurrentWorkingDir();
		HashMap<String,String> values   	=    new HashMap<String,String>();
		
		try{ 
		   String propertyType				=	"Prod";
		   values							=	SUtil.loadProperties(propertyType);
		   String workbooksheet	    		=	values.get("workbooksheet");
		   String workbooksheetPath			=	dir+"\\"+workbooksheet+".xlsx";
		   System.out.println("workbooksheetPath :"+workbooksheetPath);
		   File f=new File(workbooksheetPath); 
           FileInputStream fis = new FileInputStream(f);
           
           XSSFWorkbook  workbook=new XSSFWorkbook (fis);   
           int AllSheets =  workbook.getNumberOfSheets();
           for(int i=0;i<AllSheets;i++) {
        	   XSSFSheet sheet = workbook.getSheetAt(i);
        	   if(sheet.getSheetName().equals("ALL")) {
        		   for(Row row:sheet) {
        			  for(Cell cell:row) {
        				   String TestName 		=	"";
        				   String Status		=	"";
        				   
        				   if(cell.getStringCellValue().equals("FirstTestCase")) {
        					   TestName 		=   cell.getStringCellValue();
        					   System.out.println("FirstTestCases :"+TestName);
        				   }
        				   if(cell.getStringCellValue().equals("Yes")) {
        					   Status 			=   cell.getStringCellValue();
        					   System.out.println("Status :"+Status);
        				   }
        			   }
        			}
        	   }
        	   fis.close();
           }
		}catch (Exception e) { 
        	e.printStackTrace(); 
        	
        } 
    }
}
