package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.ShopService;
import core.basesyntax.strategy.handler.TransactionStrategy;
import java.util.List;

public class ShopServiceImpl implements ShopService {
    private final TransactionStrategy strategy;

    public ShopServiceImpl(TransactionStrategy strategy) {
        this.strategy = strategy;
    }

    @Override
    public void process(List<FruitTransaction> transactions) {
        for (FruitTransaction transaction : transactions) {
            checkTransaction(transaction);
            strategy.execute(transaction);
        }
    }

    private void checkTransaction(FruitTransaction transaction) {
        if (isEmpty(transaction)) {
            throw new RuntimeException("Empty transaction");
        }
        if (isNegative(transaction)) {
            throw new RuntimeException("Transaction quantity can't be negative");
        }
        if (haveName(transaction)) {
            throw new RuntimeException("Unexpected name");
        }
    }

    private boolean isNegative(FruitTransaction transaction) {
        return transaction.getQuantity() < 0;
    }

    private boolean isEmpty(FruitTransaction transaction) {
        return transaction == null;
    }

    private boolean haveName(FruitTransaction transaction) {
        return transaction.getName().isEmpty();
    }

}
