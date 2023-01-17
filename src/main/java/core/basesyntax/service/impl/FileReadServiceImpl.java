package core.basesyntax.service.impl;

import core.basesyntax.service.FileReadService;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class FileReadServiceImpl implements FileReadService {

    @Override
    public List<String> readFromFile(String fileName) {
        List<String> data;
        try {
            data = Files.readAllLines(Path.of(fileName));
        } catch (IOException e) {
            throw new RuntimeException("Can't read data from file " + Path.of(fileName), e);
        }
        if (data.size() != 0) {
            data.remove(0);
        }
        return data;
    }
}
