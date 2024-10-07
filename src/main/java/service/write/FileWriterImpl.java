package service.write;

import java.io.BufferedWriter;
import java.io.IOException;

public class FileWriterImpl implements FileWriter {
    @Override
    public void write(String data, String filePath) {
        try (BufferedWriter writer = new BufferedWriter(new java.io.FileWriter(filePath))) {
            writer.write(data);
        } catch (IOException e) {
            throw new RuntimeException("Error writing the file: " + filePath, e);
        }
    }
}
