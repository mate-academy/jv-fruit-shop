package core.basesyntax.service.impl;

import core.basesyntax.service.ReadFromFileService;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class ReadFromFileServiceImpl implements ReadFromFileService {
    @Override
    public String readFromFile(String path) {
        try {
            return Files.readString(Path.of(path));
        } catch (FileNotFoundException e) {
            throw new RuntimeException("Can't find a file " + path);
        } catch (IOException e) {
            throw new RuntimeException("Can't read data from file " + path);
        }
    }
}
