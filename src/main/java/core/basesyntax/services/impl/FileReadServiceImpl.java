package core.basesyntax.services.impl;

import core.basesyntax.services.FileReadService;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class FileReadServiceImpl implements FileReadService {
    @Override
    public List<String> readDataFromFile(String pathName) {
        List<String> dataFile = null;
        try {
            dataFile = Files.readAllLines(Path.of(pathName));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return dataFile;
    }
}
