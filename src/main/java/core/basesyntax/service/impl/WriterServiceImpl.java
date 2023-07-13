package core.basesyntax.service.impl;

import core.basesyntax.service.WriterService;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class WriterServiceImpl implements WriterService {
    @Override
    public void writeToFile(String report, String filePath) {
        File file = new File(filePath);
        try (BufferedWriter buff = new BufferedWriter(new FileWriter(file))) {
            buff.write(report);
        } catch (IOException e) {
            throw new RuntimeException("Can not write data to " + filePath);
        }
    }
}
