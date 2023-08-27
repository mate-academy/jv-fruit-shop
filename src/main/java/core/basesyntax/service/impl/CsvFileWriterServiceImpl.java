package core.basesyntax.service.impl;

import core.basesyntax.service.CsvFileWriterService;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class CsvFileWriterServiceImpl implements CsvFileWriterService {

    @Override
    public void writeToFile(String path, String report) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(path))) {
            if (!report.isEmpty()) {
                bufferedWriter.write(report);
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't find file on path: " + path, e);
        }
    }
}


