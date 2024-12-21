package common;

import java.io.FileOutputStream;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import Fillo.Recordset;


public class TestDataHandler {

	public static XSSFSheet ExcelWSheet;
	public static XSSFWorkbook ExcelWBook;
    public static XSSFCell Cell;
    public static XSSFRow Row;
	
	public String url;
	public String make;
	public String enginePerformance;
	public String dateOfManufacture;
	public String numberOfSeats;
	public String fuelType;
	public String listPrice;
	public String licensePlateNumber;
	public String annualMileage;
	public String firstName;
	public String lastName;
	public String dateOfBirth;
	public String streetAddress;
	public String country;
	public String zipCode;
	public String city;
	public String occupation;
	public String startDate;
	public String insuranceSum;
	public String meritRating;
	public String damageInsurance;
	public String courtesyCar;
	public String email;
	public String username;
	public String password;
	public String confirmPassword;
	
	public static TestDataHandler loadTestData(String sheet, String... where) throws Exception {
		
		Recordset record = DataRepository.testDataToBeUsed().getRowData(sheet, where);
		return loadTestData(record);
		
	}
	
	public static TestDataHandler loadTestData(Recordset record) throws Exception {
		TestDataHandler testDataHandler = new TestDataHandler();
		testDataHandler.url = record.getField("URL");
		testDataHandler.make = record.getField("Make");
		testDataHandler.enginePerformance = record.getField("Engine Performance");
		testDataHandler.dateOfManufacture = record.getField("Date of Manufacture");
		testDataHandler.numberOfSeats = record.getField("Number of Seats");
		testDataHandler.fuelType = record.getField("Fuel Type");
		testDataHandler.listPrice = record.getField("List Price");
		testDataHandler.licensePlateNumber = record.getField("License Plate Number");
		testDataHandler.annualMileage = record.getField("Annual Mileage");
		testDataHandler.firstName = record.getField("First Name");
		testDataHandler.lastName = record.getField("Last Name");
		testDataHandler.dateOfBirth = record.getField("Date of Birth");
		testDataHandler.streetAddress = record.getField("Street Address");
		testDataHandler.country = record.getField("Country");
		testDataHandler.zipCode = record.getField("Zip Code");
		testDataHandler.city = record.getField("City");
		testDataHandler.occupation = record.getField("Occupation");
		testDataHandler.startDate = record.getField("Start Date");
		testDataHandler.insuranceSum = record.getField("Insurance Sum");
		testDataHandler.meritRating = record.getField("Merit Rating");
		testDataHandler.damageInsurance = record.getField("Damage Insurance");
		testDataHandler.courtesyCar = record.getField("Courtesy Car");
		testDataHandler.email = record.getField("Email");
		testDataHandler.username = record.getField("Username");
		testDataHandler.password = record.getField("Password");
		testDataHandler.confirmPassword = record.getField("Confirm Password");
		
		return testDataHandler;
		
	}
	
	private static int getRowContains(int colNum, String sTestCaseName) throws Exception{
		int i;

		try {
			
			int rowCount = getRowUsed();
			outer:
			for ( i=1 ; i < rowCount; i++){
  				if  (getCellData(i,colNum).equalsIgnoreCase(sTestCaseName)){
	    			break outer;
				} 
			}
			return i;
				}catch (Exception e){
			throw(e);
			}
		}
	
	private static int getRowUsed() throws Exception {
			try{
				int RowCount = ExcelWSheet.getLastRowNum();
				return RowCount;
			}catch (Exception e){
				System.out.println(e.getMessage());
				throw (e);
			}

		} 
	
	 //This method is to read the test data from the Excel cell, in this we are passing parameters as Row num and Col num
	 private static String getCellData(int RowNum, int ColNum) throws Exception{
	      String CellData = null;

	  	try{	        	   
	      	  Cell = ExcelWSheet.getRow(RowNum).getCell(ColNum);	        	  
	      	  //Cell.setCellType(Cell.CELL_TYPE_STRING);
	      	  CellData = Cell.getStringCellValue();
	       
	  	  		return CellData;
	            
	            }catch (Exception e){
	              return"";
	            }
	  }	  

	public static void loadIterativeTestData() throws Exception {
		//These steps iterates the input of Worksheet information which are derived from excel
        int lastRow = ExcelWSheet.getLastRowNum();
        System.out.println("Last Row with data is:  "+lastRow);
        //int rowcount = 0;
        int startrow = getRowContains(0, "CreateWorkSheetTest");
        System.out.println("start row is "+startrow);
        int rowUsed = 0;
        for (int i=0; i<lastRow+1; i++ ) {
               String testname = getCellData(i,0);
               //System.out.println(testname);
               if (testname.equalsIgnoreCase("CreateWorksheetTest")) {                           
                     rowUsed +=1;
               }                    
        }

	}
	
	public static String writeCellValue(int RowNum, int ColNum, String text ) throws Exception{
	      String text1 = "exception error";
	  	try{	        	   
	      	  Cell = ExcelWSheet.getRow(RowNum).getCell(ColNum);
	      	  System.out.println("setCellValue Row Number: "+RowNum+" and colnum "+ColNum);      	 
	      	  Cell.setCellType(org.apache.poi.ss.usermodel.Cell.CELL_TYPE_STRING);      	    
	      	  String filepath = "C:\\Workspace\\WetravelProject\\src\\acn\\testdata\\SampleTestData.xlsx";
	      	  FileOutputStream webdata=new FileOutputStream(filepath);
	      	  Cell.setCellValue(text); 
	      	  ExcelWBook.write(webdata);
	      	  return text1;            
	            }catch (Exception e){
	            	return text1;
	            }
	  	}
	
}
