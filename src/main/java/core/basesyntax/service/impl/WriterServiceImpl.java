package core.basesyntax.service.impl;

import core.basesyntax.service.WriterService;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class WriterServiceImpl implements WriterService {
    @Override
    public void writeReportToCsvFile(String report, String pathToFile) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(pathToFile))) {
            writer.write(report);
        } catch (IOException exception) {
            throw new RuntimeException("Can't find file by path: " + pathToFile, exception);
        }
    }
}
