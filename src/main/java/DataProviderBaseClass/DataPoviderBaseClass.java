package DataProviderBaseClass;

import java.io.IOException;

import org.testng.annotations.DataProvider;

import com.utility.XLUtility;

public class DataPoviderBaseClass {
//	@DataProvider(name="LoginData")
//	public String [][] getData() throws IOException
//	{
//		//get the data from excel
//		String path=".\\datafiles\\loginData.xlsx";
//		XLUtility xlutil=new XLUtility(path);
//		
//		int totalrows=xlutil.getRowCount("Sheet1");
//		int totalcols=xlutil.getCellCount("Sheet1",1);	
//				
//		String loginData[][]=new String[totalrows][totalcols];
//			
//		
//		for(int i=1;i<=totalrows;i++) //1
//		{
//			for(int j=0;j<totalcols;j++) //0
//			{
//				loginData[i-1][j]=xlutil.getCellData("Sheet1", i, j);
//			}
//				
//		}
//		return loginData;
//}
	

}