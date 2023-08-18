package core.basesyntax.impl;

import core.basesyntax.service.ReaderService;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class ReaderServiceImpl implements ReaderService<String> {
    @Override
    public List<String> readFromFile(String addressFile, List<String> data) {
        try {
            return Files.readAllLines(Path.of(addressFile));
        } catch (IOException e) {
            throw new RuntimeException("Can't read data from file "
                    + addressFile, e);
        }
    }
}
