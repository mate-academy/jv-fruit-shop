package core.basesyntax.service.impl;

import core.basesyntax.service.WriteFileService;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class WriteFileServiceImpl implements WriteFileService {

    @Override
    public void writeToFile(String path, String data) {
        try {
            Files.writeString(Path.of(path), data);
        } catch (IOException e) {
            throw new RuntimeException(
                    String.format("Can`t write data: %s ,to file %s", data, path));
        }
    }
}
