package core.basesyntax.service.impl;

import core.basesyntax.service.WriteToFileService;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class WriteToFileServiceImpl implements WriteToFileService {
    @Override
    public void writeToFile(String reportString, String toFileName) {
        try {
            Files.writeString(Path.of(toFileName), reportString);
        } catch (IOException e) {
            throw new RuntimeException("Can not write to file " + toFileName);
        }
    }
}
