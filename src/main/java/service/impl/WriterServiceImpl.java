package service.impl;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import service.WriterService;

public class WriterServiceImpl implements WriterService {

    @Override
    public void writeToFile(String filePath, String report) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(
                new FileWriter(report))) {
            bufferedWriter.write(filePath);
        } catch (IOException e) {
            throw new RuntimeException("Can't write to file" + filePath, e);
        }
    }
}
