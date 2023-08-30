package service.impl;

import service.FileWriterService;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileWriterServiceImpl implements FileWriterService {

    @Override
    public void fileWriter(String report, String filePath) {
        File fileReport = new File(filePath);
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fileReport))) {
            bufferedWriter.write(report);
        } catch (IOException e) {
            throw new RuntimeException("Can't write data to file: " + filePath, e);
        }
    }
}
