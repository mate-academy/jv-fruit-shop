package core.basesyntax.service.impl;

import core.basesyntax.service.Reader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class ReadImpl implements Reader {
    @Override
    public List<String> fileReader(String file) {
        List<String> dataShop;
        try {
            dataShop = Files.readAllLines(Path.of(file));
        } catch (IOException e) {
            throw new RuntimeException("Can't to read file " + file, e);
        }
        return dataShop;
    }
}
