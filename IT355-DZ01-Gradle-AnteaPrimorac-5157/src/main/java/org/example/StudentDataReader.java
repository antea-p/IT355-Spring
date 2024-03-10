package org.example;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.util.Iterator;

public class StudentDataReader {

    public void readStudentData(String filePath) {
        try (FileInputStream file = new FileInputStream(filePath);
             Workbook workbook = new XSSFWorkbook(file)) {

            Sheet sheet = workbook.getSheetAt(0);
            Iterator<Row> rowIterator = sheet.iterator();
            rowIterator.next(); // Preskoči header

            while (rowIterator.hasNext()) {
                Row row = rowIterator.next();
                // Preskakanje redova koji nemaju točno 3 ćelije
                if (row.getPhysicalNumberOfCells() != 3) {
                    System.out.println("Skipping invalid row...");
                    continue;
                }

                String name = safelyReadCellAsString(row.getCell(0));
                String surname = safelyReadCellAsString(row.getCell(1));
                String id = safelyReadCellAsString(row.getCell(2));

                System.out.println(name + ", " + surname + ", " + id);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private String safelyReadCellAsString(Cell cell) {
        if (cell == null) return "Unknown"; // Slučaj null ćelije
        return switch (cell.getCellType()) {
            case STRING -> cell.getStringCellValue();
            case NUMERIC -> String.format("%.0f", cell.getNumericCellValue());
            case BLANK -> "Blank";
            default -> "Invalid";
        };
    }
}