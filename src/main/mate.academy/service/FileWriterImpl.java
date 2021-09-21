package service;

import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;

public class FileWriterImpl implements FileWriter {

    @Override
    public void writeFile(String fileName, String report) {
        File file = new File(fileName);
        try (BufferedWriter bufferedWriter = new BufferedWriter(new java.io.FileWriter(file))) {
            bufferedWriter.write(report);
        } catch (IOException e) {
            throw new RuntimeException("Can't write to file " + fileName, e);
        }
    }
}