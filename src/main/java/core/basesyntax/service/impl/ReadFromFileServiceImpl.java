package core.basesyntax.service.impl;

import core.basesyntax.service.ReadFromFileService;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class ReadFromFileServiceImpl implements ReadFromFileService {
    @Override
    public String readFromFile(String pathToFile) {
        String readFromFile;
        try {
            readFromFile = Files.readString(Path.of(pathToFile));
        } catch (IOException e) {
            throw new RuntimeException("Can't find file by path: " + pathToFile, e);
        }
        return readFromFile;
    }
}
