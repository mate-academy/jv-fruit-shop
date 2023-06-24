package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.FruitShopService;
import core.basesyntax.strategy.TransactionStrategy;
import java.util.List;

public class FruitShopServiceImpl implements FruitShopService {
    private TransactionStrategy transactionStrategy;

    public FruitShopServiceImpl(TransactionStrategy transactionStrategy) {
        this.transactionStrategy = transactionStrategy;
    }

    @Override
    public void process(List<FruitTransaction> listOfOperations) {
        listOfOperations.forEach(s -> transactionStrategy.getTransactionService(s.getOperation())
                .makeTransaction(s.getFruit(),s.getQuantity()));
    }
}
