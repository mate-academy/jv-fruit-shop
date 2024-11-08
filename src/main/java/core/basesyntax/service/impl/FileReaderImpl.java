package core.basesyntax.service.impl;

import core.basesyntax.service.Reader;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class FileReaderImpl implements Reader {
    private static final int ROW_TO_SKIP = 1;

    @Override
    public List<String> readFile(String path) {
        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            return reader.lines()
                    .skip(ROW_TO_SKIP)
                    .toList();
        } catch (IOException e) {
            throw new RuntimeException("The file by path "
                    + path + " cannot be read or does not exist.", e);
        }
    }
}
