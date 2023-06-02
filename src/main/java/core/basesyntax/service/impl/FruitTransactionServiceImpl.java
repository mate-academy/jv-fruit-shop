package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.FruitTransactionService;

public class FruitTransactionServiceImpl implements FruitTransactionService {
    @Override
    public FruitTransaction createTransaction(String operationCode, String fruit, int quantity) {
        return FruitTransaction.of(operationCode, fruit, quantity);
    }
}
