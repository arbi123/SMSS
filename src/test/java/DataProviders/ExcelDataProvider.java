package DataProviders;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ExcelDataProvider {

    @DataProvider(name = "festatData")
    public Object[][] getDataFromExcel() throws IOException {
        String excelFilePath = "C:\\Users\\Arbi.topi\\IdeaProjects\\TestimTemp\\ExcelFiles\\DitetPushim2025.xlsx";  // Vendos vendndodhjen e saktë të skedarit
        FileInputStream fis = new FileInputStream(excelFilePath);
        Workbook workbook = new XSSFWorkbook(fis);
        Sheet sheet = workbook.getSheetAt(0); // Merr faqen e parë

        List<Object[]> data = new ArrayList<>();
        Iterator<Row> rowIterator = sheet.iterator();
        rowIterator.next(); // Kalo rreshtin e parë që është header

        while (rowIterator.hasNext()) {
            Row row = rowIterator.next();
            String date = row.getCell(0).getStringCellValue();
            String event = row.getCell(1).getStringCellValue();
            data.add(new Object[]{date, event});
        }

        workbook.close();
        fis.close();

        return data.toArray(new Object[0][0]);
    }
}
