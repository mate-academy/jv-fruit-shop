package core.basesyntax.service.impl;

import core.basesyntax.service.Reader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class ReaderImpl implements Reader {
    private static final int TITLE_INDEX = 0;

    @Override
    public List<String> read(String path) {
        List<String> fruitTransactions;
        try {
            fruitTransactions = Files.readAllLines(Path.of(path));
            fruitTransactions.remove(TITLE_INDEX);
        } catch (IOException e) {
            throw new RuntimeException("Error reading fruit transactions from " + path);
        }
        return fruitTransactions;
    }
}
