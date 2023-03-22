package core.basesyntax.service.filereader;

import core.basesyntax.model.FruitTransaction;
import java.util.List;

public interface ParseDataFromFile {
    List<FruitTransaction> parsedFruitsTransactions(List<String> fruitsTransactions);
}
