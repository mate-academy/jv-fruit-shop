package core.basesyntax.services;

import core.basesyntax.model.FruitTransaction;

public class FruitShopServiceImpl implements FruitShopService {

    private final TransactionStrategy transactionStrategy;

    public FruitShopServiceImpl(TransactionStrategy transactionStrategy) {
        this.transactionStrategy = transactionStrategy;
    }

    @Override
    public void doTransaction(FruitTransaction transaction) {
        transactionStrategy.get(transaction.getOperation())
                .handle(transaction.getFruitName(), transaction.getQuantity());
    }
}
