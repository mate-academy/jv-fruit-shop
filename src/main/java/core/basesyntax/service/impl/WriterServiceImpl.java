package core.basesyntax.service.impl;

import core.basesyntax.service.WriterService;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class WriterServiceImpl implements WriterService {
    @Override
    public void writeToFile(String report, String filePath) {
        try (BufferedWriter buff = new BufferedWriter(new FileWriter(filePath))) {
            buff.write(report);
        } catch (IOException e) {
            throw new RuntimeException("Can not write data to " + filePath);
        }
    }
}
