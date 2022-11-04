package core.basesyntax.service.impl;

import core.basesyntax.dao.FruitsDao;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.MakerTransaction;
import core.basesyntax.strategy.OperationStrategy;
import java.util.List;

public class MakerTransactionsImpl implements MakerTransaction {
    private final OperationStrategy operationStrategy;
    private FruitsDao fruitsDao;

    public MakerTransactionsImpl(OperationStrategy operationStrategy,
                                 FruitsDao fruitsDao) {
        this.operationStrategy = operationStrategy;
        this.fruitsDao = fruitsDao;
    }

    @Override
    public void doTransactions(List<FruitTransaction> transactions) {
        transactions.stream()
                .forEach(t -> fruitsDao.save(t.getFruit(),
                        operationStrategy.get(t.getOperation())
                                .handle(fruitsDao.get(t.getFruit()), t.getQuantity())));
    }
}
