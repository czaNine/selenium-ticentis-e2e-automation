package common;

import auto.framework.DataTable;
import auto.framework.DataTable.DataTableInstance;

public class DataRepository {

	private static InheritableThreadLocal<DataTableInstance> standardTestDataTable = new InheritableThreadLocal<DataTableInstance>();
	
	public static DataTableInstance testDataToBeUsed(){
		String dataFilePath =  "./src/test/resources/data/StandardTestData.xlsx";
		DataTableInstance newValue = DataTable.Load( dataFilePath );
		standardTestDataTable.set(newValue);
		return newValue;
	}

}
