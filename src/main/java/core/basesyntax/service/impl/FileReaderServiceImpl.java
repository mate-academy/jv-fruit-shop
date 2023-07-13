package core.basesyntax.service.impl;

import core.basesyntax.service.FileReaderService;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileReaderServiceImpl implements FileReaderService {

    @Override
    public String readFile(String path) {
        String dataFromFile = "";
        try {
            dataFromFile = Files.readString(Path.of(path));
        } catch (IOException e) {
            throw new RuntimeException("Can`t read data from file" + path, e);
        }
        return dataFromFile;
    }
}
