package service.impl;

import java.io.BufferedWriter;
import java.io.IOException;
import java.util.List;

public class FileWriter {
    public void write(List<String> report, String filePath) {
        try (BufferedWriter writer = new BufferedWriter(new java.io.FileWriter(filePath))) {
            for (String row : report) {
                writer.write(row);
                writer.newLine();
            }
        } catch (IOException e) {
            throw new RuntimeException("Cannot read file");
        }
    }
}
