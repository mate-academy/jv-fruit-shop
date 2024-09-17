package core.basesyntax.service.impl;

import core.basesyntax.service.CsvFileWriterService;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class CsvFileWriterServiceImpl implements CsvFileWriterService {
    private static final String REPORT_PATH = "src\\main\\resources\\report.csv";

    @Override
    public void writeToFile(String report) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(REPORT_PATH));
        bufferedWriter.write(report);
        bufferedWriter.close();
    }
}
