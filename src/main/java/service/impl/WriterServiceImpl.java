package service.impl;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import service.WriterService;

public class WriterServiceImpl implements WriterService {
    @Override
    public void writeToFile(String report, String filePath) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            writer.write(report);
        } catch (FileNotFoundException e) {
            throw new RuntimeException("Invalid file name: " + filePath, e);
        } catch (IOException e) {
            throw new RuntimeException("Write failed", e);
        }
    }
}
