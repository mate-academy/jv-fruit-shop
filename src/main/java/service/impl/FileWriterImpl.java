package service.impl;

import java.io.BufferedWriter;
import java.io.IOException;
import service.FileWriter;

public class FileWriterImpl implements FileWriter {
    @Override
    public void write(String report, String fileName) {
        try (BufferedWriter writer = new BufferedWriter(new java.io.FileWriter(fileName))) {
            writer.write(report);
        } catch (IOException e) {
            throw new RuntimeException("Can't write to file " + fileName, e);
        }
    }
}
