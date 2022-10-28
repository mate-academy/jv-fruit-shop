package core.basesyntax.service.impl;

import core.basesyntax.service.WriteInFileService;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class WriteInFileServiceImpl implements WriteInFileService {
    @Override
    public void writeInFile(String data, String path) {
        try {
            Files.writeString(Path.of(path), data);
        } catch (IOException e) {
            throw new RuntimeException("Can`t write data to file" + path, e);
        }
    }
}
