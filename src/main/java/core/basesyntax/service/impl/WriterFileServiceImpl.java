package core.basesyntax.service.impl;

import core.basesyntax.service.WriterFileService;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class WriterFileServiceImpl implements WriterFileService {
    @Override
    public void write(String path, String data) {
        try {
            Files.writeString(Path.of(path), data);
        } catch (IOException e) {
            throw new RuntimeException("Cant write data in file by path " + path, e);
        }
    }
}
