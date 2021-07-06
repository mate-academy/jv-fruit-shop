package service;

import java.io.BufferedWriter;
import java.io.IOException;

public class FileWriterImpl implements FileWriter {
    @Override
    public void writeToFile(String report, String fileName) {
        try (BufferedWriter writer = new BufferedWriter(new java.io.FileWriter(fileName))) {
            writer.write(report);
        } catch (IOException e) {
            throw new RuntimeException("Can't write to file" + fileName, e);
        }
    }
}
