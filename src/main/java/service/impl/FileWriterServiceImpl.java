package service.impl;

import java.io.BufferedWriter;
import java.io.IOException;
import service.FileWriterService;

public class FileWriterServiceImpl implements FileWriterService {
    @Override
    public void writeToFile(String report, String filePathTo) {
        try (BufferedWriter writer = new BufferedWriter(new java.io.FileWriter(filePathTo))) {
            writer.write(report);
        } catch (IOException e) {
            throw new RuntimeException("Incorrect path name!");
        }
    }
}
