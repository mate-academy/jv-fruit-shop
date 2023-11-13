package service.impl;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import service.WriteService;

public class WriteServiceImpl implements WriteService {

    @Override
    public void writeReport(String filePath, String report) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            writer.write(report);
        } catch (IOException e) {
            throw new RuntimeException("file " + filePath + "not found");
        }
    }
}
