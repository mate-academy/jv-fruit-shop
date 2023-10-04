package core.basesyntax.service.impl;

import core.basesyntax.service.WriteToFileService;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class WriteToFileServiceImpl implements WriteToFileService {
    @Override
    public void writeToFile(String outputFilePath, String reportString) {
        try {
            Files.writeString(Path.of(outputFilePath), reportString);
        } catch (IOException e) {
            throw new RuntimeException("Can't write to file " + outputFilePath, e);
        }
    }
}
