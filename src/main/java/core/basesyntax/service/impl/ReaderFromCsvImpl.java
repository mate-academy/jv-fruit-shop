package core.basesyntax.service.impl;

import core.basesyntax.service.ReaderFromCsv;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class ReaderFromCsvImpl implements ReaderFromCsv {

    @Override
    public List<String> read(String filePath) {
        try {
            return Files.readAllLines(Paths.get(filePath));
        } catch (IOException e) {
            throw new RuntimeException("Can't find file by path: " + filePath, e);
        }
    }
}
