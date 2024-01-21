package impl;

import java.io.FileWriter;
import java.io.IOException;
import service.WriterService;

public class WriterServiceImpl implements WriterService {
    @Override
    public void writeDataToFile(String report, String filePath) {
        try (FileWriter writer = new FileWriter(filePath)) {
            writer.write(report);
        } catch (IOException e) {
            throw new RuntimeException("Can`t write to file: " + filePath, e);
        }
    }
}
