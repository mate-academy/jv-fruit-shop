package core.basesyntax.service.impl;

import core.basesyntax.service.StorageWriteService;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class StorageWriteServiceImpl implements StorageWriteService {
    private static final String EXCEPTION_MESSAGE = "Cannot write report to file ";
    private static final String SUCCESS_MESSAGE = "Success! The report was "
            + "successfully saved to the file ";

    @Override
    public String writeFromDb(String report, String filePath) {
        File file = new File(filePath);
        byte[] dataToWrite = report.getBytes();
        try {
            Files.write(file.toPath(), dataToWrite);
            return SUCCESS_MESSAGE + filePath;
        } catch (IOException e) {
            throw new RuntimeException(EXCEPTION_MESSAGE + file.toString());
        }
    }
}
