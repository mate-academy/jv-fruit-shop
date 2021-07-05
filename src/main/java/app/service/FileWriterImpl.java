package app.service;

import java.io.BufferedWriter;

public class FileWriterImpl implements FileWriter {
    @Override
    public void writeToFile(String report, String fileName) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new java.io.FileWriter(fileName))) {
            bufferedWriter.write(report);
        } catch (Exception e) {
            throw new RuntimeException("Can't write data to the file " + fileName, e);
        }
    }
}
