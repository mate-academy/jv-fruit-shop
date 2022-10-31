package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;
import java.util.List;

public interface FruitTransactionData {
    List<FruitTransaction> parseDataFromFile(List<String> dataFromFile);
}
