package DataProviders;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;

public class ShtoInstitucioninDP {
    @DataProvider(name = "excelData")
    public static Object[][] readExcelData() throws IOException {
        String excelFilePath = "path/to/your/excel.xlsx"; // Change this to your file path
        FileInputStream file = new FileInputStream(new File(excelFilePath));
        Workbook workbook = new XSSFWorkbook(file);
        Sheet sheet = workbook.getSheetAt(0);

        int rowCount = sheet.getPhysicalNumberOfRows() - 1; // Exclude header
        int colCount = sheet.getRow(0).getPhysicalNumberOfCells();

        Object[][] data = new Object[rowCount][colCount];

        Iterator<Row> rowIterator = sheet.iterator();
        rowIterator.next(); // Skip header row

        int i = 0;
        while (rowIterator.hasNext()) {
            Row row = rowIterator.next();
            for (int j = 0; j < colCount; j++) {
                if (j == 0) { // FilePath column
                    data[i][j] = row.getCell(j, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK).toString();
                } else if (j == 6 || j == 14) { // Institucioni (G) & Njësia (O) columns
                    data[i][j] = ""; // Leave empty
                } else {
                    data[i][j] = row.getCell(j, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK).toString();
                }
            }
            i++;
        }
        workbook.close();
        return data;
    }
}
