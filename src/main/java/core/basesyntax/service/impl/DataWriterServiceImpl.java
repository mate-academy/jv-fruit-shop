package core.basesyntax.service.impl;

import core.basesyntax.service.DataWriterService;
import java.io.FileWriter;
import java.io.IOException;

public class DataWriterServiceImpl implements DataWriterService {
    @Override
    public void writeReportToFile(String report, String fileName) {
        try (FileWriter writer = new FileWriter(fileName)) {
            writer.write(report + System.lineSeparator());
        } catch (IOException e) {
            throw new RuntimeException("Can't write report to file " + fileName, e);
        }
    }
}
