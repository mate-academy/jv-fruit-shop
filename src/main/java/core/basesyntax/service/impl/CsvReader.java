package core.basesyntax.service.impl;

import core.basesyntax.service.Reader;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

public class CsvReader implements Reader {
    @Override
    public List<String> read(String source) {
        File fileToRead = new File(source);
        List<String> strings;
        try {
            strings = Files.readAllLines(fileToRead.toPath());
        } catch (IOException e) {
            throw new RuntimeException("Can't read from file " + source, e);
        }
        return strings;
    }
}
