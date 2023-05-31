package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;
import java.util.List;

public interface FruitTransactionParserService {
    List<FruitTransaction> parseToFruitTransaction(List<String> dataFromFile);
}
