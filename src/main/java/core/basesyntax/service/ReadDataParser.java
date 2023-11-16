package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;
import java.util.List;

public interface ReadDataParser {
    List<FruitTransaction> convertToFruitTransactionList(List<String> fileLines);
}
