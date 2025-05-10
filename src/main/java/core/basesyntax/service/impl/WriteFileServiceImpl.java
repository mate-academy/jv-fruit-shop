package core.basesyntax.service.impl;

import core.basesyntax.service.WriteFileService;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class WriteFileServiceImpl implements WriteFileService {
    @Override
    public void writeToFile(String data, Path path) {
        try {
            Files.writeString(path, data);
        } catch (IOException e) {
            throw new RuntimeException("Can't write data to file " + path, e);
        }
    }
}
