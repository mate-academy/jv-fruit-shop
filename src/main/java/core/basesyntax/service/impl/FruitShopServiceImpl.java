package core.basesyntax.service.impl;

import core.basesyntax.service.FruitShopService;
import core.basesyntax.strategy.TransactionStrategy;
import java.util.List;

public class FruitShopServiceImpl implements FruitShopService {
    private TransactionStrategy transactionStrategy;

    public FruitShopServiceImpl() {
        this.transactionStrategy = new TransactionStrategy();
    }

    @Override
    public void process(List<String[]> listOfOperations) {
        listOfOperations.forEach(s -> transactionStrategy.getTransactionService().get(s[0])
                .makeTransaction(s[1],Integer.parseInt(s[2])));
    }
}
