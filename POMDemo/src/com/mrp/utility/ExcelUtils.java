package com.mrp.utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;



public class ExcelUtils {
	
	
	public static String Path_TestData="";
	public static String path="C:\\Users\\OMG\\Desktop\\Selenium.xlsx";
	/*public static XSSFWorkbook workbook;	
	public static XSSFSheet worksheet;	
	public static XSSFCell Cell;
	public static FileInputStream fis;
	public static String cellData="";
	
	public String selectSheet(String filepath,String sheetName) throws Exception
	{
	fis=new FileInputStream("C:\\Users\\OMG\\Desktop\\Selenium.xlsx");
	try {
		workbook = new XSSFWorkbook(fis);
		worksheet = workbook.getSheet("MyClass");
		
	//int lastrow=worksheet.getLastRowNum();
	int rowsCount = worksheet.getPhysicalNumberOfRows();
	System.out.println("rows"+rowsCount);
	//Column count
	int ColCount = worksheet.getRow(0).getPhysicalNumberOfCells();
	System.out.println("cols"+ColCount);
	
	
	Cell=worksheet.getRow(2).getCell(2);
	
	cellData=Cell.getStringCellValue();
	System.out.println(cellData);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

	return cellData;
	}*/
	public static XSSFWorkbook workbook;	
	public static XSSFSheet worksheet;	
	public static XSSFCell Cell;
	public static FileInputStream fis;
	public static String cellData="";
	public static XSSFRow Row;
      //private static XSSFRow Row;
 
  public static void setExcelFile(String Path) throws Exception {
  	try {
          FileInputStream ExcelFile = new FileInputStream(Path);
          workbook = new XSSFWorkbook(ExcelFile);
          System.out.println("workbook"+workbook);
  	} catch (Exception e){
  		
  		
      	}
  	}
  
  public static String getCellData(int RowNum, int ColNum, String SheetName ) throws Exception{
      try{
    	  worksheet = workbook.getSheet(SheetName);
    	  System.out.println("worksheet"+worksheet);
         	Cell = worksheet.getRow(RowNum).getCell(ColNum);
          String CellData = Cell.getStringCellValue();
          return CellData;
       }catch (Exception e){
    	   return"";
           }
      
       }
  
	
	public static int getRowCount(String SheetName){
		int iNumber=0;
		try {
			worksheet = workbook.getSheet(SheetName);
			iNumber=worksheet.getLastRowNum()+1;
		} catch (Exception e){
			
			}
		return iNumber;
		}
	
	public static int getRowContains(String sTestCaseName, int colNum,String SheetName) throws Exception{
		int iRowNum=0;	
		try {
		    //ExcelWSheet = ExcelWBook.getSheet(SheetName);
			int rowCount = ExcelUtils.getRowCount(SheetName);
			for (; iRowNum<rowCount; iRowNum++){
				if  (ExcelUtils.getCellData(iRowNum,colNum,SheetName).equalsIgnoreCase(sTestCaseName)){
					break;
				}
			}       			
		} catch (Exception e){
			
			}
		return iRowNum;
		}
	
	/*public static int getTestStepsCount(String SheetName, String sTestCaseID, int iTestCaseStart) throws Exception{
		try {
  		for(int i=iTestCaseStart;i<=ExcelUtils.getRowCount(SheetName);i++){
  			if(!sTestCaseID.equals(ExcelUtils.getCellData(i, Constants.Col_TestCaseID, SheetName))){
  				int number = i;
  				return number;      				
  				}
  			}
  		worksheet = workbook.getSheet(SheetName);
  		int number=worksheet.getLastRowNum()+1;
  		return number;
		} catch (Exception e){
			
      }
	}
	*/
	@SuppressWarnings("static-access")
	public static void setCellData(String Result,  int RowNum, int ColNum, String SheetName) throws Exception    {
         try{
      	   
        	 worksheet = workbook.getSheet(SheetName);
             Row  = worksheet.getRow(RowNum);
             Cell = Row.getCell(ColNum, Row.RETURN_BLANK_AS_NULL);
             if (Cell == null) {
          	   Cell = Row.createCell(ColNum);
          	   Cell.setCellValue(Result);
              } else {
                  Cell.setCellValue(Result);
              }
               FileOutputStream fileOut = new FileOutputStream(Path_TestData);
               workbook.write(fileOut);
               //fileOut.flush();
               fileOut.close();
               workbook = new XSSFWorkbook(new FileInputStream(Path_TestData));
           }catch(Exception e){
          	 
    
           }
      }

}


