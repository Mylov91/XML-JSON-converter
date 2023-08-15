package ru.mylov;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


public class JsonWriter {
    private static JsonWriter jsonWriter;
    private static final Logger logger = Logger.getLogger(ExcelWriter.class.getName());

    public static JsonWriter getJsonWriter() {
        if (jsonWriter == null) {
            jsonWriter = new JsonWriter();
        }
        return jsonWriter;
    }

    public void writeJson(Structure structure) throws IOException {
        logger.log(Level.INFO, "Starting json writer");
        List<String> jsonList = new ArrayList<>();
        String studentsJson = JsonUtil.listToJson(Structure.getStudentsFromExcelList());
        String universitiesJson = JsonUtil.listToJson(Structure.getUniversitiesFromExcelList());
        String statisticsJson = JsonUtil.listToJson(Structure.getStatisticsList());
        jsonList.add(studentsJson);
        jsonList.add(universitiesJson);
        jsonList.add(statisticsJson);

        Files.createDirectories(Paths.get("target/jsonReqs"));
        File file = new File("target/jsonReqs/" + Structure.getTimestamp() + ".json");
        FileWriter fw = new FileWriter(file);

        for (int i = 0; i < jsonList.size(); i++) {
            fw.write(jsonList.get(i));
        }
        logger.log(Level.INFO, "Json file writing is finished");
        fw.close();
    }
}