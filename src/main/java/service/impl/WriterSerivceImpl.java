package service.impl;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;
import service.WriterSerivce;

public class WriterSerivceImpl implements WriterSerivce {
    @Override
    public void writeToFile(String outputFilePath, Map<String, Integer> fruitCounts) {
        String fileName = outputFilePath;
        try (PrintWriter creatingReport =
                     new PrintWriter(new FileWriter(fileName))) {
            creatingReport.println("fruit,quantity");
            for (Map.Entry<String, Integer> entry : fruitCounts.entrySet()) {
                creatingReport.println(entry.getKey() + "," + entry.getValue());
            }
        } catch (IOException e) {
            throw new RuntimeException("Error writing to file: " + fileName, e);
        }
    }
}

