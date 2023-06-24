package core.basesyntax.service.impl;

import core.basesyntax.service.WriteDataToFileService;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class WriteDataToFileServiceImpl implements WriteDataToFileService {

    @Override
    public void writeReport(String report, String fileName) {
        try {
            Files.writeString(Path.of(fileName), report);
        } catch (IOException e) {
            throw new RuntimeException("Can't write data to file " + fileName, e);
        }
    }
}
