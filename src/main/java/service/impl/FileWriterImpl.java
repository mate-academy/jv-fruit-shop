package service.impl;

import java.io.BufferedWriter;
import java.io.IOException;
import service.FileWriter;

public class FileWriterImpl implements FileWriter {
    @Override
    public void writeToFile(String report, String pathFile) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new java.io.FileWriter(pathFile))) {
            bufferedWriter.write(report);
        } catch (IOException e) {
            throw new RuntimeException("Report cannot be write to file " + pathFile, e);
        }
    }
}
