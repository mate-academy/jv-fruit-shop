package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;
import java.util.List;

public interface GenerationDataForStorage {
    void generateData(List<FruitTransaction> transactionList);
}
