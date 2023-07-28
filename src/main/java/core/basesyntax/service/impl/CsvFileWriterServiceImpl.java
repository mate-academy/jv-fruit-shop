package core.basesyntax.service.impl;

import core.basesyntax.service.CsvFileWriterService;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class CsvFileWriterServiceImpl implements CsvFileWriterService {
    @Override
    public void write(String report, String path) {
        checkReportForNull(report, path);
        try (BufferedWriter bufferedWriter =
                     new BufferedWriter(new FileWriter(path))) {
            bufferedWriter.write(report);
        } catch (IOException e) {
            throw new RuntimeException("Can't write report in file((", e);
        }
    }

    private void checkReportForNull(String report, String path) {
        if (report == null || path == null) {
            throw new RuntimeException("Input report or path is null!");
        }
    }
}
