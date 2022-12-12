package core.basesyntax.services.impl;

import core.basesyntax.services.ReaderService;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class ReaderServiceImpl implements ReaderService {
    @Override
    public String readFile(String path) {
        String dateFromFile;
        try {
            dateFromFile = Files.readString(Path.of(path));
        } catch (IOException e) {
            throw new RuntimeException("Can not read data from file" + path, e);
        }
        return dateFromFile;
    }
}
