package service.impl;

import db.Storage;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;
import service.WriteService;

public class WriteServiceImpl implements WriteService {
    private static final String OUTPUT_HEADER = "fruit,quantity";
    private static final String NEW_LINE = "\n";
    private static final String SEPARATOR = ",";

    @Override
    public void writeToFile(String filePath) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(filePath))) {
            StringBuilder builder = new StringBuilder();
            builder.append(OUTPUT_HEADER);
            builder.append(NEW_LINE);
            for (Map.Entry<String, Integer> entry : Storage.storage.entrySet()) {
                builder.append(entry.getKey()).append(SEPARATOR).append(entry.getValue());
                builder.append(NEW_LINE);
            }
            bufferedWriter.write(builder.toString().trim());
        } catch (IOException e) {
            throw new RuntimeException("Can't write to file" + filePath);
        }
    }
}
