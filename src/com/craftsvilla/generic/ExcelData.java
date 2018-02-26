package com.craftsvilla.generic;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class ExcelData implements AutoConst
{
	
	public static int getRowCount(String strFilePath, String strSheetName)
	{
		FileInputStream fin = null;
		Workbook wb =null;
		Sheet sh =null;
		int rc=0;
		
		try
		{
			fin = new FileInputStream(strFilePath);
			wb = new XSSFWorkbook(fin);
			sh=wb.getSheet(strSheetName);
			if(sh==null)
				return -1;
			rc = sh.getPhysicalNumberOfRows();
			return rc;
		}
		catch(Exception e)
		{
			return -1;
		}
		
		finally
		{
			try
			{
			sh=null;
			((FileInputStream) wb).close();
			wb=null;
			fin.close();
			fin=null;
			}
			catch(Exception e)
			{
				return -1;
			}
		}
	}
	
	
	public static String getCellValue(String strFilePath,String strtSheetName, String strColName, int rowNum)
	{
		FileInputStream fin = null;
		Workbook wb = null;
		Sheet sh = null;
		Row row = null;
		Cell cell;
		
		int celNum = 0;
		
		try
		{
			fin = new FileInputStream(strFilePath);
			wb = new XSSFWorkbook(fin);
			sh = wb.getSheet(strtSheetName);
			
			if(sh == null) return null;
			else
			row = sh.getRow(0);		
			String strCellData = null;
			for(int c =0; c< row.getLastCellNum();c++)
			{
			cell = row.getCell(c);
			if(cell.getStringCellValue().trim().equalsIgnoreCase(strColName.trim()))
			{
				celNum = c;
				break;
				
			}
			
			row = sh.getRow(rowNum);
			cell= row.getCell(celNum);
			strCellData = cell.getStringCellValue();
		
			}
			return strCellData;
		}
		catch(Exception e)
		{
			return null;
		}
		
		finally
		{
			try
			{
			cell = null;
			row = null;
			sh = null;
			((FileInputStream)wb).close();
			wb = null;
			fin.close();
			fin = null;
			}catch(Exception e)
			{
				return null;
			}
		}
				
	}

}
