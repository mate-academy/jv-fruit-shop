package core.basesyntax.service.impl;

import core.basesyntax.service.WriteFileService;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class WriteFileServiceImpl implements WriteFileService {
    @Override
    public void writeFile(String path, String report) {
        try {
            Files.writeString(Path.of(path), report);
        } catch (IOException e) {
            throw new RuntimeException("Can't write file" + path + e);
        }
    }
}
