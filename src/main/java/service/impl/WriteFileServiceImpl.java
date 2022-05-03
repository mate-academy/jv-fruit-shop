package service.impl;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import service.WriteFileService;

public class WriteFileServiceImpl implements WriteFileService {
    @Override
    public void write(String report, String fileName) {
        try (BufferedWriter csvWriter = new BufferedWriter(new FileWriter(fileName))) {
            csvWriter.write(report);
        } catch (IOException e) {
            throw new RuntimeException("Can't write to file " + fileName);
        }
    }
}
