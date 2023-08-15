package ru.mylov;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import ru.enums.StudyProfile;
import ru.model.Statistics;
import ru.model.Student;
import ru.model.University;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.*;


public class ExcelReader {
    private static ExcelReader excelReader;
    private static final Logger logger = Logger.getLogger(ExcelReader.class.getName());


    public ExcelReader() {
    }

    public static ExcelReader getExcelReader() {
        if (excelReader == null) {
            excelReader = new ExcelReader();
            logger.log(Level.INFO, "Excel reader created");
        }
        return excelReader;
    }

    public List<Student> readStudents() throws IOException {
        FileInputStream fis = new FileInputStream("src/main/resources/universityInfo.xlsx");
        XSSFWorkbook wb = new XSSFWorkbook(fis);
        List<Student> studentsList = new ArrayList<>();
        XSSFSheet sheet = wb.getSheetAt(0);
        Iterator<Row> rowIterator = sheet.iterator();
        rowIterator.next();
        while (rowIterator.hasNext()) {
            Row currentRow = rowIterator.next();
            Student student = new Student();
            studentsList.add(student);
            student.setUniversityId(currentRow.getCell(0).getStringCellValue());
            student.setFullName(currentRow.getCell(1).getStringCellValue());
            student.setCurrentCourseNumber((int) currentRow.getCell(2).getNumericCellValue());
            student.setAvgExamScore((float) currentRow.getCell(3).getNumericCellValue());
        }
        logger.log(Level.INFO, "All student records read");
        fis.close();
        Structure.setStudentsFromExcelList(studentsList);
        return Structure.getStudentsFromExcelList();
    }

    public List<University> readUniversities() throws IOException {
        FileInputStream fis = new FileInputStream("src/main/resources/universityInfo.xlsx");
        XSSFWorkbook wb = new XSSFWorkbook(fis);
        List<University> universitiesList = new ArrayList<>();
        XSSFSheet sheet = wb.getSheetAt(1);
        Iterator<Row> rowIterator = sheet.iterator();
        rowIterator.next();
        while (rowIterator.hasNext()) {
            Row currentRow = rowIterator.next();
            University university = new University();
            universitiesList.add(university);
            university.setId(currentRow.getCell(0).getStringCellValue());
            university.setFullName(currentRow.getCell(1).getStringCellValue());
            university.setShortName(currentRow.getCell(2).getStringCellValue());
            university.setYearOfFoundation((int) currentRow.getCell(3).getNumericCellValue());
            university.setMainProfile(StudyProfile.valueOf(StudyProfile.class, currentRow.getCell(4).getStringCellValue()));
        }
        logger.log(Level.INFO, "All university records read");
        fis.close();
        Structure.setUniversitiesFromExcelList(universitiesList);
        return Structure.getUniversitiesFromExcelList();
    }

    public List<Statistics> readStatistics() throws IOException {
        FileInputStream fis = new FileInputStream("src/main/resources/statistics.xlsx");
        XSSFWorkbook wb = new XSSFWorkbook(fis);
        List<Statistics> statisticsList = new ArrayList<>();
        XSSFSheet sheet = wb.getSheetAt(0);
        Iterator<Row> rowIterator = sheet.iterator();
        rowIterator.next();
        while (rowIterator.hasNext()) {
            Row currentRow = rowIterator.next();
            Statistics statistic = new Statistics();
            statisticsList.add(statistic);
            statistic.setStudyProfile(StudyProfile.valueOf(currentRow.getCell(0).getStringCellValue()));
            statistic.setAvgExamScore((float) currentRow.getCell(1).getNumericCellValue());
            statistic.setStudentsCountOnProfile((int) currentRow.getCell(2).getNumericCellValue());
            statistic.setUniversitiesCountOnProfile((int) currentRow.getCell(3).getNumericCellValue());
            statistic.setUniversityName(currentRow.getCell(4).getStringCellValue());
        }
        logger.log(Level.INFO, "All statistical records read");
        fis.close();
        Structure.setStatisticsList(statisticsList);
        return Structure.getStatisticsList();
    }
}