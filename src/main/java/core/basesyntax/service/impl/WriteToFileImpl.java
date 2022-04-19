package core.basesyntax.service.impl;

import core.basesyntax.service.WriteToFileService;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class WriteToFileImpl implements WriteToFileService {
    @Override
    public void writeToFile(String pathName, String report) {
        try {
            Files.write(Path.of(pathName), report.getBytes());
        } catch (IOException e) {
            throw new RuntimeException("Can't write data to file " + pathName, e);
        }
    }
}


