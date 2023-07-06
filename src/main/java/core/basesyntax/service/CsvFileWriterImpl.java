package core.basesyntax.service;

import core.basesyntax.dao.InputDao;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class CsvFileWriterImpl implements CsvFileWriter {
    private static final String TITLE_LINE_OF_REPORT_FILE = "fruit,quantity";
    private static final String BANANA = "banana";
    private static final String APPLE = "apple";
    private InputDao inputDao;

    public CsvFileWriterImpl(InputDao inputDao) {
        this.inputDao = inputDao;
    }

    @Override
    public void createReportFile(String reportFilePath) {
        File file = new File(reportFilePath);
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file))) {
            StringBuilder builder = new StringBuilder(TITLE_LINE_OF_REPORT_FILE);
            builder.append(System.lineSeparator())
                    .append(inputDao.getFromStorage(BANANA))
                    .append(System.lineSeparator())
                    .append(inputDao.getFromStorage(APPLE));
            bufferedWriter.write(builder.toString());
        } catch (IOException e) {
            throw new RuntimeException("Can't write data to file", e);
        }
    }
}
