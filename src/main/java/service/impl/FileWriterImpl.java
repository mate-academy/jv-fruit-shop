package service.impl;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import service.FileWriterService;

public class FileWriterImpl implements FileWriterService {
    public boolean writeData(String toFilePath, String data) {
        File file = new File(toFilePath);
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file))) {
            bufferedWriter.write(data);
            return true;
        } catch (IOException e) {
            throw new RuntimeException("Can't write data to file: " + toFilePath, e);
        }
    }
}