package service.impl;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;
import service.FileService;

public class FileServiceImpl implements FileService {

    @Override
    public List<String> read(String filePath) {
        File file = new File(filePath);
        try {
            return Files.readAllLines(file.toPath());
        } catch (IOException e) {
            throw new RuntimeException("Can't read from file " + filePath, e);
        }
    }

    @Override
    public void write(String reportPath, String report) {
        File fileReport = new File(reportPath);
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fileReport))) {
            bufferedWriter.write(report);
        } catch (IOException e) {
            throw new RuntimeException("Can`t write data to file " + reportPath, e);
        }
    }
}
