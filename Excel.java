import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Excel   {

    public static void createExcelFile() throws IOException {
        File file = new File("employes.xlsx");
        if(!file.exists()){
            XSSFWorkbook xssfWorkbook = new XSSFWorkbook();
            Sheet sheet = xssfWorkbook.createSheet("demo");

                /*
                Object employesData[][] = {
                        {"Employ_id", "Name", "Job"},
                        {1, "Ivan", "Web Developer"},
                        {2, "Pesho", "Manager"},
                        {3, "Gosho", "Web Developer"}
                };

                int rows = employesData.length;
                int cols = employesData[0].length;

                for (int r = 0; r < rows; r++) {
                    XSSFRow row = (XSSFRow) sheet.createRow(r);
                    for (int c = 0; c < cols; c++) {
                        XSSFCell cell = row.createCell(c);
                        Object value = employesData[r][c];
                        if(value instanceof String){
                            cell.setCellValue((String) value);
                        }
                        if(value instanceof Integer){
                            cell.setCellValue((int) value);
                        }
                    }
                }
                 */

            ArrayList<Object[]> employesData = new ArrayList<Object[]>();
            employesData.add(new Object[]{"ID","Name","Job"});
            employesData.add(new Object[]{1,"Ivan","Web Developer"});
            employesData.add(new Object[]{2,"Pesho","Manager"});
            employesData.add(new Object[]{3,"Gosho","Web Developer"});
            employesData.add(new Object[]{3,"Stamat","Seller"});

            int rowCount = 0;

            for(Object emp[] : employesData){
                XSSFRow row = (XSSFRow) sheet.createRow(rowCount++);
                int cellNum = 0;
                for(Object value : emp){
                    XSSFCell cell = row.createCell(cellNum++);
                    if(value instanceof String){
                        cell.setCellValue((String) value);
                    }
                    if(value instanceof Integer){
                        cell.setCellValue((int) value);
                    }
                }
            }

            FileOutputStream out = new FileOutputStream(new File("employes.xlsx"));
            xssfWorkbook.write(out);
            out.close();
            System.out.println("File create successfully");
        }else {
            System.out.println("All ready created");
        }
    }

    public static void printExcelFile() throws IOException {
        String fileName = "employes.xlsx";
        Path path = Paths.get(fileName);
        String filePath = path.toAbsolutePath().toString();

        //String path ="C:\\Users\\Admin\\IdeaProjects\\POI\\employes.xlsx";
        FileInputStream fileInputStream = new FileInputStream(filePath);
        XSSFWorkbook xssfWorkbook = new XSSFWorkbook(fileInputStream);
        XSSFSheet sheet = xssfWorkbook.getSheetAt(0);

        int rows = sheet.getLastRowNum();
        int cols = sheet.getRow(0).getLastCellNum();

        for (int r = 0; r < rows + 1; r++) {
            XSSFRow xssfRow = sheet.getRow(r);
            for (int c = 0; c < cols; c++) {
                XSSFCell xssfCel = xssfRow.getCell(c);
                switch (xssfCel.getCellType()){
                    case NUMERIC -> System.out.print((int)xssfCel.getNumericCellValue() + " ");
                    case STRING -> System.out.print(xssfCel.getStringCellValue());
                }
                System.out.print(" | ");
            }
            System.out.println();
        }
    }
}
