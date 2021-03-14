import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;
import java.io.IOException;

public class ReportExcelConverter {
    public void toExcel(Report report, String sheetName, String file) throws IOException {
        Workbook book = new XSSFWorkbook();
        Sheet sheet = book.createSheet(sheetName);

        int rowNum = 0;
        int colNum = 0;
        int colSize = report.getFieldNames().size();

        Row row = sheet.createRow(rowNum);
        for (String fieldName : report.getFieldNames()) {
            Cell field = row.createCell(colNum);
            field.setCellValue(fieldName);
            colNum += 1;
        }

        for (String fieldValue : report.getFieldValues()) {
            if ((colNum)%colSize == 0) {
                rowNum += 1;
                row = sheet.createRow(rowNum);
                colNum = 0;
            }

            Cell value = row.createCell(colNum);
            value.setCellValue(fieldValue);
            colNum += 1;
        }

        sheet.autoSizeColumn(1);
        book.write(new FileOutputStream(file));
    }
}
