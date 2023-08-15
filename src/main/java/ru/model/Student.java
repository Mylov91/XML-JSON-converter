package ru.model;
import com.google.gson.annotations.SerializedName;
import javax.xml.bind.annotation.*;


@XmlAccessorType(XmlAccessType.FIELD)
public class Student extends ModelParent {
    @XmlElement(name = "studentName")
    @SerializedName("studentName")
    private String fullName;
    @XmlElement(name = "universityId")
    @SerializedName("universityIdentifier")
    private String universityId;
    @XmlTransient
    @SerializedName("studentCourse")
    private int currentCourseNumber;
    @XmlElement(name = "avgScore")
    @SerializedName("studentAvgScore")
    private float avgExamScore;


    public void setFullName(String fullName) {
        this.fullName = fullName;
    }


    public void setUniversityId(String universityId) {
        this.universityId = universityId;
    }


    public void setCurrentCourseNumber(int currentCourseNumber) {
        this.currentCourseNumber = currentCourseNumber;
    }


    public void setAvgExamScore(float avgExamScore) {
        this.avgExamScore = avgExamScore;
    }

    public String getFullName() {
        return fullName;
    }

    public String getUniversityId() {
        return universityId;
    }

    public int getCurrentCourseNumber() {
        return currentCourseNumber;
    }

    public float getAvgExamScore() {
        return avgExamScore;
    }

    @Override
    public String toString() {
        return "\n" + "Name of student: " + getFullName() + ", university ID: " + getUniversityId() +
                ", current course number: " + getCurrentCourseNumber() + ", average exam score: " + getAvgExamScore() + "\n";
    }
}
