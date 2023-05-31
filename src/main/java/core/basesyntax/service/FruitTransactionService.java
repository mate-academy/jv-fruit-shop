package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;
import jdk.dynalink.Operation;

public interface FruitTransactionService {
    void createFruitTransaction(String operationCode, String fruit, int quantity);
}
