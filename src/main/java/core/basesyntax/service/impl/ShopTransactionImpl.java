package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.ShopTransaction;
import core.basesyntax.service.TransactionStrategy;
import java.util.List;

public class ShopTransactionImpl implements ShopTransaction {
    private final TransactionStrategy activitiesStrategy;

    public ShopTransactionImpl(TransactionStrategy activitiesStrategy) {
        this.activitiesStrategy = activitiesStrategy;
    }

    @Override
    public void makeTransaction(List<FruitTransaction> transactions) {
        for (FruitTransaction transaction: transactions) {
            activitiesStrategy.getTransaction(transaction.getOperation())
                    .transaction(transaction.getFruit(), transaction.getQuantity());
        }
    }
}
