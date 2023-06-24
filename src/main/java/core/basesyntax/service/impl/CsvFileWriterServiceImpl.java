package core.basesyntax.service.impl;

import core.basesyntax.service.CsvFileWriterService;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class CsvFileWriterServiceImpl implements CsvFileWriterService {
    @Override
    public void writeToFile(String writeToFilePath, String report) {
        try (PrintWriter printWriter = new PrintWriter(new FileWriter(writeToFilePath))) {
            printWriter.println(report);
        } catch (IOException e) {
            throw new RuntimeException("Can't write to this path: "
                    + writeToFilePath, e);
        }
    }
}
