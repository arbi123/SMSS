package DataProviders;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
public class PerdoruesConfigDataProvider {


    @DataProvider(name = "formData")
    public Object[][] getFormData() {
        String excelFilePath = "C:\\Users\\Arbi.topi\\IdeaProjects\\TestimTemp\\ExcelFiles\\PerdoruesConfig.xlsx";
        List<Object[]> data = new ArrayList<>();

        try (FileInputStream fis = new FileInputStream(excelFilePath);
             Workbook workbook = new XSSFWorkbook(fis)) {

            Sheet sheet = workbook.getSheetAt(0); // Get first sheet

            // Skip the header row (row 0) and read data from row 1 (second row)
            Row row = sheet.getRow(1);
            if (row != null) {
                Object[] rowData = new Object[15]; // 15 parameters for fillForm method

                // Read cell values and convert as needed
                rowData[0] = getCellValueAsString(row.getCell(0)); // email
                rowData[1] = getCellValueAsString(row.getCell(1)); // nid
                rowData[2] = getCellValueAsString(row.getCell(2)); // ditelindja
                rowData[3] = getCellValueAsString(row.getCell(3)); // emer
                rowData[4] = getCellValueAsString(row.getCell(4)); // mbimer
                rowData[5] = getCellValueAsString(row.getCell(5)); // atesi
                rowData[6] = getCellValueAsString(row.getCell(6)); // nrTel
                rowData[7] = getCellValueAsString(row.getCell(7)); // puna
                rowData[8] = getCellValueAsString(row.getCell(8)); // adresa
                rowData[9] = getCellValueAsString(row.getCell(9)); // koment

                // Convert string values to boolean for checkboxes
                rowData[10] = Boolean.parseBoolean(getCellValueAsString(row.getCell(10))); // inaktive
                rowData[11] = Boolean.parseBoolean(getCellValueAsString(row.getCell(11))); // DKN

                rowData[12] = getCellValueAsString(row.getCell(12)); // institucion
                rowData[13] = getCellValueAsString(row.getCell(13)); // njesia
                rowData[14] = getCellValueAsString(row.getCell(14)); // rolet

                data.add(rowData);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return data.toArray(new Object[0][]);
    }

    // Helper method to handle different cell types and return as String
    private String getCellValueAsString(Cell cell) {
        if (cell == null) {
            return "";
        }

        switch (cell.getCellType()) {
            case STRING:
                return cell.getStringCellValue();
            case NUMERIC:
                if (DateUtil.isCellDateFormatted(cell)) {
                    return cell.getLocalDateTimeCellValue().toString();
                } else {
                    // Convert numeric value to string without decimal if it's a whole number
                    double value = cell.getNumericCellValue();
                    if (value == Math.floor(value)) {
                        return String.format("%.0f", value);
                    } else {
                        return String.valueOf(value);
                    }
                }
            case BOOLEAN:
                return String.valueOf(cell.getBooleanCellValue());
            case FORMULA:
                return cell.getCellFormula();
            default:
                return "";
        }
    }
}
