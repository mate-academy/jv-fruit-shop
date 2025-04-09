package core.basesyntax.service.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.BalanceSetter;
import java.util.List;

public class BalanceSetterImpl implements BalanceSetter {
    private final Storage storage;

    public BalanceSetterImpl(Storage storage) {
        this.storage = storage;
    }

    @Override
    public void setBalance(List<FruitTransaction> fruitTransactions) {
        fruitTransactions.stream()
                .filter(fruitTransaction
                        -> fruitTransaction.getOperation() == FruitTransaction.Operation.BALANCE)
                .forEach(fruitTransaction
                        -> storage.updateFruitBalance(
                                fruitTransaction.getFruit(),
                                fruitTransaction.getQuantity()
                        )
                );
    }
}
