package ru.mylov;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import ru.model.Statistics;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


public class ExcelWriter {
    static Statistics statistic;
    private static final Logger logger = Logger.getLogger(ExcelWriter.class.getName());

    public static void createTable(List<Statistics> statisticsList, String excelPath) {
        logger.log(Level.INFO, "Starting excel writer");
        XSSFWorkbook wb = new XSSFWorkbook();
        XSSFSheet sheet = wb.createSheet("Статистика");
        Row titleRow = sheet.createRow(0);

        CellStyle headerStyle = wb.createCellStyle();
        headerStyle.setAlignment(HorizontalAlignment.CENTER);
        Font font = wb.createFont();
        font.setFontHeightInPoints((short) 16);
        font.setBold(true);
        headerStyle.setFont(font);

        Cell cell0 = titleRow.createCell(0);
        cell0.setCellValue("Профиль обучения");
        cell0.setCellStyle(headerStyle);

        Cell cell1 = titleRow.createCell(1);
        cell1.setCellValue("Средний балл за экзамен");
        cell1.setCellStyle(headerStyle);

        Cell cell2 = titleRow.createCell(2);
        cell2.setCellValue("Количество студентов по профилю");
        cell2.setCellStyle(headerStyle);

        Cell cell3 = titleRow.createCell(3);
        cell3.setCellValue("Количество университетов по профилю");
        cell3.setCellStyle(headerStyle);

        Cell cell4 = titleRow.createCell(4);
        cell4.setCellValue("Название университета");
        cell4.setCellStyle(headerStyle);

        for (int i = 0; i < statisticsList.size(); i++) {
            Row row = sheet.createRow(i + 1);
            statistic = statisticsList.get(i);
            row.createCell(0).setCellValue(String.valueOf(statistic.getStudyProfile()));
            row.createCell(1).setCellValue(statistic.getAvgExamScore());
            row.createCell(2).setCellValue(statistic.getStudentsCountOnProfile());
            row.createCell(3).setCellValue(statistic.getUniversitiesCountOnProfile());
            row.createCell(4).setCellValue(statistic.getUniversityName());
            for (int j = 0; j <= 4; j++) {
                sheet.autoSizeColumn(j);
            }
        }

        try {
            FileOutputStream fos = new FileOutputStream(excelPath);
            wb.write(fos);
            fos.close();
        } catch (IOException e) {
            logger.log(Level.SEVERE, "Excel file writing failed, path is incorrect", e);
        }

        logger.log(Level.INFO, "Statistics sheet writing is finished");
    }
}
