package fruit.shop.service;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class WriterServiceImpl implements WriterService {
    @Override
    public void saveReport(String report, String path) {
        try (BufferedWriter writer = new BufferedWriter(
                new FileWriter(path + "Report.csv", false))
        ) {
            writer.write(report);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
