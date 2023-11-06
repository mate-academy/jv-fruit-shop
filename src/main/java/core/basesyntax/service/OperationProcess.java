package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;
import java.util.List;

public interface OperationProcess {
    void processTransaction(List<FruitTransaction> fruitTransactions);
}
