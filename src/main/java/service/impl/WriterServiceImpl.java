package service.impl;

import java.io.FileWriter;
import java.io.IOException;
import service.WriterService;

public class WriterServiceImpl implements WriterService {
    @Override
    public void writeToFile(String report, String filePath) {
        try (FileWriter writer = new FileWriter(filePath)) {
            writer.write(report);
        } catch (IOException e) {
            throw new RuntimeException("Can't write file by path: " + filePath, e);
        }
    }
}
