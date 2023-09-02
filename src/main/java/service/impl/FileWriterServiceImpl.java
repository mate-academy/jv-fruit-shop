package service.impl;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import service.FileWriterService;

public class FileWriterServiceImpl implements FileWriterService {
    @Override
    public void fileWriter(String report, String writeFile) {
        File fileReport = new File(writeFile);
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fileReport))) {
            bufferedWriter.write(report);
        } catch (IOException e) {
            throw new RuntimeException("Can't write data to file: " + writeFile, e);
        }
    }
}
