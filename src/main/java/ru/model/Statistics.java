package ru.model;
import ru.enums.StudyProfile;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlTransient;

@XmlAccessorType(XmlAccessType.FIELD)
public class Statistics extends ModelParent {
    @XmlElement(name = "universityProfile")
    private StudyProfile studyProfile;
    @XmlElement(name = "avgScore")
    private float avgExamScore;
    @XmlTransient
    private int studentsCountOnProfile;
    @XmlTransient
    private int universitiesCountOnProfile;
    @XmlTransient
    private String universityName;

    public Statistics() {}

    public Statistics(StudyProfile studyProfile, float avgExamScore, int studentsCountOnProfile, int universitiesCountOnProfile, String universityName) {
        this.studyProfile = studyProfile;
        this.avgExamScore = avgExamScore;
        this.studentsCountOnProfile = studentsCountOnProfile;
        this.universitiesCountOnProfile = universitiesCountOnProfile;
        this.universityName = universityName;
    }

    public StudyProfile getStudyProfile() {
        return studyProfile;
    }

    public float getAvgExamScore() {
        return avgExamScore;
    }

    public int getStudentsCountOnProfile() {
        return studentsCountOnProfile;
    }

    public int getUniversitiesCountOnProfile() {
        return universitiesCountOnProfile;
    }

    public String getUniversityName() {
        return universityName;
    }

    public void setStudyProfile(StudyProfile studyProfile) {
        this.studyProfile = studyProfile;
    }

    public void setAvgExamScore(float avgExamScore) {
        this.avgExamScore = avgExamScore;
    }

    public void setStudentsCountOnProfile(int studentsCountOnProfile) {
        this.studentsCountOnProfile = studentsCountOnProfile;
    }

    public void setUniversitiesCountOnProfile(int universitiesCountOnProfile) {
        this.universitiesCountOnProfile = universitiesCountOnProfile;
    }

    public void setUniversityName(String universityName) {
        this.universityName = universityName;
    }
}
