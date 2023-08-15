package ru.builders;
import ru.model.Student;


public interface StudentBuilder {
    StudentBuilder createFullName(String fullName);
    StudentBuilder createUniversityId(String universityId);
    StudentBuilder createCurrentCourseNumber(int currentCourseNumber);
    StudentBuilder createAvgExamScore(float avgExamScore);
    Student build();
}
