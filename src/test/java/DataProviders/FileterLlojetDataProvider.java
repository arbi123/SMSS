package DataProviders;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;

public class FileterLlojetDataProvider {
    @DataProvider(name = "serviceTypes")
    public Object[][] getServiceTypes() throws IOException {
        String filePath = "C:\\Users\\Arbi.topi\\IdeaProjects\\TestimTemp\\ExcelFiles\\LlojetEsherbimitFilter.xlsx";  // Change this path
        String sheetName = "Sheet1"; // Adjust if needed
        return readExcelData(filePath, sheetName);
    }

    private Object[][] readExcelData(String filePath, String sheetName) throws IOException {
        try (FileInputStream fis = new FileInputStream(filePath);
             Workbook workbook = new XSSFWorkbook(fis)) {

            Sheet sheet = workbook.getSheet(sheetName);
            int rowCount = sheet.getLastRowNum();  // Number of rows (excluding header)
            Object[][] data = new Object[rowCount][1]; // 1 column (String)

            // Iterate from row 1 (skip header row 0)
            Iterator<Row> rowIterator = sheet.iterator();
            rowIterator.next(); // Skip header

            int i = 0;
            while (rowIterator.hasNext()) {
                Row row = rowIterator.next();
                data[i][0] = row.getCell(0).getStringCellValue().trim(); // Read as String
                i++;
            }
            return data;
        }
    }
}
