package core.basesyntax.service.impl;

import core.basesyntax.service.ReadService;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class ReadServiceImpl implements ReadService {
    @Override
    public List<String> readFromFile(String fileName) {
        try {
            List<String> list = Files.readAllLines(Path.of(fileName));
            list.remove(0);
            return list;
        } catch (IOException e) {
            throw new RuntimeException("Can't get data from file " + fileName, e);
        }
    }

}
