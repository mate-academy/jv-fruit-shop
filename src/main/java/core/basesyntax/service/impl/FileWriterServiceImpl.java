package core.basesyntax.service.impl;

import core.basesyntax.errors.ErrorMessages;
import core.basesyntax.service.FileWriterService;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class FileWriterServiceImpl implements FileWriterService {
    private final String filePath;

    public FileWriterServiceImpl(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public void write(String dataToWrite) {
        validateDataToWrite(dataToWrite);
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(filePath))) {
            bufferedWriter.write(dataToWrite);
        } catch (IOException e) {
            throw new RuntimeException(ErrorMessages.CAN_T_WRITE_DATA_TO_THE_FILE + filePath, e);
        }
    }

    private void validateDataToWrite(String dataToWrite) {
        if (dataToWrite == null) {
            throw new IllegalArgumentException(ErrorMessages.DATA_FOR_WRITING_CANNOT_BE_NULL);
        }
    }
}
