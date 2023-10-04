package core.basesyntax.service.impl;

import core.basesyntax.service.CsvFileWriterService;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class CsvFileWriterServiceImpl implements CsvFileWriterService {
    @Override
    public void write(String report, String path) {
        checkReportForNull(report);
        checkPathForNull(path);
        try (BufferedWriter bufferedWriter =
                     new BufferedWriter(new FileWriter(path))) {
            bufferedWriter.write(report);
        } catch (IOException e) {
            throw new RuntimeException("Can't write report in file", e);
        }
    }

    private void checkPathForNull(String path) {
        if (path == null) {
            throw new RuntimeException("Input path is null!");
        }
    }

    private void checkReportForNull(String report) {
        if (report == null) {
            throw new RuntimeException("Input report is null!");
        }
    }
}
