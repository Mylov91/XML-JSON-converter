package ru.mylov;
import ru.comparators.StudentComparator;
import ru.comparators.UniversityComparator;
import ru.enums.StudentComparatorType;
import ru.enums.UniversityComparatorType;
import ru.model.Statistics;
import ru.model.Student;
import ru.model.University;

import javax.xml.bind.JAXBException;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.logging.LogManager;
import java.util.logging.Logger;


public class Main {
    public static final Logger log = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) throws IOException, JAXBException {

        try {
            FileInputStream fis = new FileInputStream("src/main/resources/logging.properties");
            LogManager.getLogManager().readConfiguration(fis);
            fis.close();
        } catch (IOException e) {
            System.err.println("Could not setup logger configuration: " + e);
        }
        log.info("Application is successfully started");

        List<Student> studentsFromExcelList = ExcelReader.getExcelReader().readStudents();
        StudentComparator studentComparator =
                ComparatorUtil.getStudentComparator(StudentComparatorType.FULL_NAME);
        studentsFromExcelList.sort(studentComparator);

        List<University> universitiesFromExcelList = ExcelReader.getExcelReader().readUniversities();
        UniversityComparator universityComparator =
                ComparatorUtil.getUniversityComparator(UniversityComparatorType.YEAR);
        universitiesFromExcelList.sort(universityComparator);

        List<Statistics> statisticsList = StatisticsUtil.createStatisticsList(studentsFromExcelList, universitiesFromExcelList);
        ExcelWriter.createTable(statisticsList, "src/main/resources/statistics.xlsx");
        ExcelReader.getExcelReader().readStatistics();

        Structure structure = new Structure();
        XmlWriter.getXmlWriter().writeXml(structure);
        JsonWriter.getJsonWriter().writeJson(structure);
        log.info("Application is successfully stopped");
    }
}