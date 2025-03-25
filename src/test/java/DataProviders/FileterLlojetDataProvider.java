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
        String filePath = "C:\\Users\\Arbi.topi\\IdeaProjects\\TestimTemp\\ExcelFiles\\LlojetEsherbimitFilter.xlsx";  // Ndrysho këtë path sipas nevojës
        String sheetName = "Sheet1"; // Ndrysho nëse është e nevojshme
        return readExcelData(filePath, sheetName);
    }

    private Object[][] readExcelData(String filePath, String sheetName) throws IOException {
        try (FileInputStream fis = new FileInputStream(filePath);
             Workbook workbook = new XSSFWorkbook(fis)) {

            Sheet sheet = workbook.getSheet(sheetName);
            int rowCount = sheet.getLastRowNum(); // Merr numrin total të rreshtave (pa përfshirë header-in)

            Object[][] data = new Object[rowCount][2]; // Numri i rreshtave dhe 2 kolona

            for (int i = 0; i < rowCount; i++) {
                Row row = sheet.getRow(i + 1); // Rreshti aktual

                if (row != null) {
                    data[i][0] = row.getCell(0) != null ? row.getCell(0).getStringCellValue().trim() : "";
                    data[i][1] = row.getCell(1) != null ? row.getCell(1).getStringCellValue().trim() : "";
                }
            }
            return data;
        }
    }
}
