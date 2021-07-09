package service;

import java.io.BufferedWriter;
import java.io.IOException;

public class FileWriterImpl implements FileWriter {
    @Override
    public void writeToFile(String report, String fileName) {
        try (BufferedWriter writer = new BufferedWriter(new java.io.FileWriter(fileName))) {
            writer.append(report);
        } catch (IOException e) {
            throw new RuntimeException("can`t write to this file - " + fileName, e);
        }
    }
}
