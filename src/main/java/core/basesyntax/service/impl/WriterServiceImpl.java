package core.basesyntax.service.impl;

import core.basesyntax.service.WriterService;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class WriterServiceImpl implements WriterService {

    @Override
    public void writeReport(String filePath, String report) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            writer.write(report);
        } catch (IOException e) {
            throw new RuntimeException("File " + filePath + " not found.");
        }
    }
}
