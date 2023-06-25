package core.basesyntax.service.impl;

import core.basesyntax.dao.FruitsDao;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.TransactionHandler;
import core.basesyntax.strategy.OperationStrategy;
import java.util.List;

public class TransactionHandlerImpl implements TransactionHandler {
    private final FruitsDao fruitsDao;
    private final OperationStrategy operationStrategy;

    public TransactionHandlerImpl(FruitsDao fruitDao, OperationStrategy operationStrategy) {
        this.fruitsDao = fruitDao;
        this.operationStrategy = operationStrategy;
    }

    @Override
    public void applyTransactions(List<FruitTransaction> transactions) {
        for (FruitTransaction transaction : transactions) {
            int currentQuantity = 0;
            if (fruitsDao.containsFruit(transaction.getFruit())) {
                currentQuantity = fruitsDao.getQuantityOfFruit(transaction.getFruit());
            }
            int newQuantity = operationStrategy.get(transaction.getOperation())
                    .executeOperation(currentQuantity, transaction.getQuantity());
            if (newQuantity < 0) {
                throw new RuntimeException("Quantity can't be less than zero");
            } else {
                fruitsDao.add(transaction.getFruit(), newQuantity);
            }
        }
    }
}
