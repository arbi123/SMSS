package DataProviders;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

import java.io.FileInputStream;
import java.io.IOException;

public class LlojiSherbimitDataProvider {
    @DataProvider(name = "excelData")
    public Object[][] getExcelData() throws IOException {
        // Adjust path & sheet name as needed
        String filePath = "C:\\Users\\Arbi.topi\\IdeaProjects\\TestimTemp\\ExcelFiles\\Lloji i sherbimit.xlsx";
        String sheetName = "Sheet1";
        return readExcelData(filePath, sheetName);
    }

    private Object[][] readExcelData(String filePath, String sheetName) throws IOException {
        try (FileInputStream fis = new FileInputStream(filePath);
             XSSFWorkbook workbook = new XSSFWorkbook(fis)) {

            XSSFSheet sheet = workbook.getSheet(sheetName);

            // Get the last row index (0-based)
            int lastRow = sheet.getLastRowNum();
            // We skip row 0 (the header), so total data rows = lastRow
            int rowCount = lastRow;

            // We have 5 columns:
            // A–D (boolean), E (string).
            int colCount = 5;
            Object[][] data = new Object[rowCount][colCount];

            for (int i = 1; i <= lastRow; i++) {
                XSSFRow row = sheet.getRow(i);

                // Column 0 (A) -> boolean
                data[i - 1][0] = getBooleanCellValue(row, 0);

                // Column 1 (B) -> boolean
                data[i - 1][1] = getBooleanCellValue(row, 1);

                // Column 2 (C) -> boolean
                data[i - 1][2] = getBooleanCellValue(row, 2);

                // Column 3 (D) -> boolean
                data[i - 1][3] = getBooleanCellValue(row, 3);

                // Column 4 (E) -> string
                data[i - 1][4] = getStringCellValue(row, 4);
            }
            return data;
        }
    }

    // Helper method to read a cell as boolean
    private boolean getBooleanCellValue(XSSFRow row, int colIndex) {
        if (row == null) return false;
        XSSFCell cell = row.getCell(colIndex);
        if (cell == null) return false;

        // If cell type is BOOLEAN, read it directly
        if (cell.getCellType() == CellType.BOOLEAN) {
            return cell.getBooleanCellValue();
        }
        // If cell is a string "TRUE"/"FALSE", parse it
        if (cell.getCellType() == CellType.STRING) {
            return Boolean.parseBoolean(cell.getStringCellValue().trim());
        }
        // If numeric or blank, handle as needed; default to false
        return false;
    }

    // Helper method to read a cell as string
    private String getStringCellValue(XSSFRow row, int colIndex) {
        if (row == null) return "";
        XSSFCell cell = row.getCell(colIndex);
        if (cell == null) return "";

        // Convert to string for any type
        return cell.toString().trim();
    }
}

