package ru.comparators;
import org.apache.commons.lang3.StringUtils;
import ru.model.Student;


public class StudentUniversityIdComparator implements StudentComparator {
    @Override
    public int compare(Student o1, Student o2) {
        return StringUtils.compare(o1.getUniversityId(), o2.getUniversityId());
    }
}
