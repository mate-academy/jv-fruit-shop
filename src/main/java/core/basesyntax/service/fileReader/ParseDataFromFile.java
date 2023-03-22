package core.basesyntax.service.fileReader;

import core.basesyntax.model.FruitTransaction;

import java.util.List;

public interface ParseDataFromFile {
    List<FruitTransaction> parsedFruitsTransactions(List<String> fruitsTransactions);
}
