package model.dto.impl;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;
import model.Fruit;
import model.dto.WriteToFile;

public class WriteToFileImpl implements WriteToFile {
    private static final String FIRST_LINE = "fruit,quantity";
    private static final String NEXT_LINE_REGEX = "\n";
    private static final String DOT = ",";
    private static final String FILE_NAME = "Report.csv";

    @Override
    public void writeToFile(Map<Fruit, Integer> map) {
        try (FileWriter fileWriter = new FileWriter("Report.csv", false)) {
            fileWriter.write(FIRST_LINE);
            fileWriter.append(NEXT_LINE_REGEX);
            for (Map.Entry<Fruit, Integer> entry : map.entrySet()) {
                fileWriter.append(entry.getKey().getName())
                        .append(DOT)
                        .append(entry.getValue().toString())
                        .append(NEXT_LINE_REGEX);
            }
        } catch (IOException e) {
            throw new RuntimeException("File not found" + FILE_NAME);
        }
    }
}
