package core.basesyntax.service.impl;

import core.basesyntax.service.StorageWriteService;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class StorageWriteServiceImpl implements StorageWriteService {
    private static final String EXCEPTION_MESSAGE = "Cannot write report to file ";

    @Override
    public void writeFromDb(String report, File toFile) {
        byte[] dataToWrite = report.getBytes();
        try {
            Files.write(toFile.toPath(), dataToWrite);
        } catch (IOException e) {
            throw new RuntimeException(EXCEPTION_MESSAGE + toFile.toString());
        }
    }
}
