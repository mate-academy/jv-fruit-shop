package core.basesyntax.service.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.service.FruitTransaction;
import core.basesyntax.service.ReaderService;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class ReaderServiceImpl implements ReaderService {
    private ParserServiceImpl parserService = new ParserServiceImpl();
    @Override
    public List<FruitTransaction> readFromFile(String fromFile) {
        List<String> fruitTransactions = new ArrayList<>();
            try {
                fruitTransactions = Files.readAllLines(Path.of(fromFile));
            } catch (IOException e) {
                throw new RuntimeException("Can't read from file " + fromFile);
            }
            fruitTransactions.remove(0);
            return parserService.getObjectsFromStrings(fruitTransactions);
    }
}
