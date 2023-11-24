package core.basesyntax.strategy;

import core.basesyntax.model.FruitTransaction;

public class BalanceTransactionService implements TransactionService {
    @Override
    public void process(FruitTransaction transaction) {
        dao.setQuantity(transaction.getFruit(), transaction.getQuantity());
    }
}
