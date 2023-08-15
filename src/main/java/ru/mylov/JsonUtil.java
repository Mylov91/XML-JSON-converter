package ru.mylov;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import ru.model.ModelParent;
import ru.model.Student;
import ru.model.University;
import java.util.List;


public class JsonUtil {
    private JsonUtil() {
    }

    public static String studentToJson(Student student) {
        return new GsonBuilder().setPrettyPrinting().create().toJson(student);
    }

    public static String universityToJson(University university) {
        return new GsonBuilder().setPrettyPrinting().create().toJson(university);
    }

    public static Student jsonToStudent(String json) {
        return new Gson().fromJson(json, Student.class);
    }

    public static University jsonToUniversity(String json) {
        return new Gson().fromJson(json, University.class);
    }

    public static List<Student> studentsJsonToList(String studentsJson) {
        return new Gson().fromJson(studentsJson, new TypeToken<List<Student>>() {
        }.getType());
    }

    public static List<University> universitiesJsonToList(String universitiesJson) {
        return new Gson().fromJson(universitiesJson, new TypeToken<List<Student>>() {
        }.getType());
    }
    public static String structureToJson(Structure structure) {
        return new GsonBuilder().setPrettyPrinting().create().toJson(structure);
    }

    public static String listToJson(List<? extends ModelParent> list) {
        return new GsonBuilder().setPrettyPrinting().create().toJson(list);
    }
}
