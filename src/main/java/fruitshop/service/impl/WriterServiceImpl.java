package fruitshop.service.impl;

import fruitshop.service.WriterService;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class WriterServiceImpl implements WriterService {
    @Override
    public void write(String reportContent, String filePath) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            writer.write(reportContent);
        } catch (IOException e) {
            throw new RuntimeException("Error writing report to file: " + filePath, e);
        }
    }
}
