package ru.mylov;

import ru.model.Statistics;
import ru.model.Student;
import ru.model.University;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import java.time.LocalDateTime;
import java.util.List;


@XmlRootElement(name = "root")
public class Structure {
    @XmlElementWrapper(name = "studentsInfo")
    @XmlElement(name = "studentEntry")
    private static List<Student> studentsFromExcelList;
    @XmlElementWrapper(name = "universitiesInfo")
    @XmlElement(name = "universityEntry")
    private static List<University> universitiesFromExcelList;
    @XmlElementWrapper(name = "statisticalInfo")
    @XmlElement(name = "statisticsEntry")
    private static List<Statistics> statisticsList;
    @XmlElement(name = "processedAt")
    private static String timestamp;

    public Structure() {
        this.timestamp = String.valueOf(LocalDateTime.now());
    }

    public static List<Student> getStudentsFromExcelList() {
        return studentsFromExcelList;
    }

    public static List<University> getUniversitiesFromExcelList() {
        return universitiesFromExcelList;
    }

    public static List<Statistics> getStatisticsList() {
        return statisticsList;
    }

    public static void setStudentsFromExcelList(List<Student> studentsFromExcelList) {
        Structure.studentsFromExcelList = studentsFromExcelList;
    }

    public static void setUniversitiesFromExcelList(List<University> universitiesFromExcelList) {
        Structure.universitiesFromExcelList = universitiesFromExcelList;
    }

    public static void setStatisticsList(List<Statistics> statisticsList) {
        Structure.statisticsList = statisticsList;
    }

    public static String getTimestamp() {
        return timestamp;
    }
}
