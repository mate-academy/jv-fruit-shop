package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.FruitTransactionService;

public class FruitTransactionServiceImpl implements FruitTransactionService {
    @Override
    public FruitTransaction createNewFruitTransaction(String FruitTransactionString) {
        String[] fields = FruitTransactionString.split(",");
        return FruitTransaction.of(fields[1],
                Integer.parseInt(fields[0]), FruitTransaction.Operation.valueOf((fields[2])));
    }
}
