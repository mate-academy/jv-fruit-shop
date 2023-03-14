package service.impl;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import service.WriteService;

public class WriteServiceImpl implements WriteService {
    private static final String OUTPUT_HEADER = "fruit,quantity";
    private static final String NEW_LINE = "\n";
    private static final String SEPARATOR = ",";

    @Override
    public void writeToFile(String filePath, String report) {
        File file = new File(filePath);
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file))) {
            bufferedWriter.write(report);
        } catch (IOException e) {
            throw new RuntimeException("Can't write to file" + filePath);
        }
    }
}
