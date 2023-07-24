package core.basesyntax.service.impl;

import core.basesyntax.service.impl.service.WriterService;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class WriterServiceImpl implements WriterService {
    private static final String EXCEPTION_INFO = "Cannot write file";
    private static final String FIRST_FILE_ROW = "fruit,quantity";
    private static final String INVALID_INPUT_PARAMETER = "Invalid input parameter in writeData()";
    private static final String EMPTY_STRING = "";

    @Override
    public void writeData(String report, String toFile) {
        if (report == null) {
            throw new RuntimeException(INVALID_INPUT_PARAMETER);
        }
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(toFile, true))) {
            eraseData(toFile);
            bufferedWriter.write(FIRST_FILE_ROW + System.lineSeparator());
            bufferedWriter.write(report);
        } catch (IOException e) {
            throw new RuntimeException(EXCEPTION_INFO, e);
        }
    }

    private void eraseData(String toFile) {
        try (FileWriter fileWriter = new FileWriter(toFile)) {
            fileWriter.write(EMPTY_STRING);
        } catch (IOException e) {
            throw new RuntimeException(EXCEPTION_INFO, e);
        }
    }
}
