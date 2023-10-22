package service;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class CsvWriterService {
    public void writeData(String filePath, List<String> data) {
        try (FileWriter writer = new FileWriter(filePath)) {
            for (String line : data) {
                writer.write(line + "\n");
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't write to the file", e);
        }
    }
}
