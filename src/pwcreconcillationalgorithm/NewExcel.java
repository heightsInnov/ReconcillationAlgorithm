/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pwcreconcillationalgorithm;

/**
 *
 * @author aojinadu
 */
import com.gizbel.excel.enums.ExcelFactoryType;
import com.gizbel.excel.factory.Parser;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import pwcreconcillationalgorithm.model.Excel;

public class NewExcel {

	public static List<Excel> Converter() throws Exception{
		List<Excel> exList = new ArrayList();
		Parser parser = new Parser(Excel.class, ExcelFactoryType.COLUMN_NAME_BASED_EXTRACTION);

		List<Object> result = parser.parse(new File("C:\\projectJava\\Reconciliationsampledata.xlsx")); //Whatever excel file you want
		result.stream().map((obj) -> (Excel) obj).forEachOrdered((ex) -> {
			exList.add(ex);
		});
		return exList;
	}
}
