package service.impl;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;
import service.Writer;

public class WriterImpl implements Writer {
    private static final String NEW_HEADER = "fruit,quantity";
    private final Map<String, Integer> mapToWrite;

    public WriterImpl(Map<String, Integer> mapToWrite) {
        this.mapToWrite = mapToWrite;
    }

    @Override
    public void write(String fileName) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            writer.write(NEW_HEADER);
            writer.newLine();
            for (Map.Entry<String, Integer> entry : mapToWrite.entrySet()) {
                String line = entry.getKey() + "," + entry.getValue();
                writer.write(line);
                writer.newLine();
            }
        } catch (IOException e) {
            throw new RuntimeException("Cant write data to file" + fileName);
        }
    }
}
