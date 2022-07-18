package core.basesyntax.service.impl;

import core.basesyntax.service.CsvFileWriterService;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class CsvFileWriterServiceImpl implements CsvFileWriterService {
    @Override
    public void writeToFile(String report, String toFileName) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(toFileName))) {
            writer.write(report);
        } catch (IOException e) {
            throw new RuntimeException("Can't write report to file by path" + toFileName, e);
        }
    }
}
