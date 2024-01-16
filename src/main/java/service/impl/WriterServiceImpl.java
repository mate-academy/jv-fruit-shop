package service.impl;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;
import service.WriterService;

public class WriterServiceImpl implements WriterService {
    @Override
    public void writeReport(Map<String, Integer> reportData, String filePath) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(filePath))) {
            writer.println("fruit,quantity");
            for (Map.Entry<String, Integer> entry : reportData.entrySet()) {
                writer.println(entry.getKey() + "," + entry.getValue());
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't find file by path: " + filePath, e);
        }
    }
}
