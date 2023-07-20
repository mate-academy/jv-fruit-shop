package core.basesyntax.service.impl;

import core.basesyntax.service.impl.service.CsvFileWriterService;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class CsvFileWriterServiceImpl implements CsvFileWriterService {
    private static final String FILE_PATH = "src/main/resources/report.csv";
    private static final String EXCEPTION_INFO = "Cannot write file";
    private static final String FIRST_FILE_ROW = "fruit,quantity";
    private static final String INVALID_INPUT_PARAMETER = "Invalid input parameter in writeData()";

    @Override
    public void writeData(String report) {
        if (report == null) {
            throw new RuntimeException(INVALID_INPUT_PARAMETER);
        }
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(FILE_PATH, true))) {
            eraseData(report);
            bufferedWriter.write(FIRST_FILE_ROW + System.lineSeparator());
            bufferedWriter.write(report);
        } catch (IOException e) {
            throw new RuntimeException(EXCEPTION_INFO, e);
        }
    }

    private void eraseData(String report) {
        try (FileWriter fileWriter = new FileWriter(FILE_PATH)) {
            fileWriter.write("");
        } catch (IOException e) {
            throw new RuntimeException(EXCEPTION_INFO, e);
        }
    }
}
