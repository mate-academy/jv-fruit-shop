package core.basesyntax.service.impl;

import core.basesyntax.service.ReadFromFileService;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class ReadFromFileServiceImpl implements ReadFromFileService {

    @Override
    public String readFromFile(String path) {
        String dataFromFile = "";
        try {
            dataFromFile = Files.readString(Path.of(path));
        } catch (IOException e) {
            throw new RuntimeException("Can`t read data from file" + path, e);
        }
        return dataFromFile;
    }
}
