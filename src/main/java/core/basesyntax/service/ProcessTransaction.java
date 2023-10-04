package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;
import java.util.List;

public interface ProcessTransaction {
    void addDataIntoStorage(List<FruitTransaction> fruitTransactionList);
}
