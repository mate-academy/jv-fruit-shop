package core.basesyntax.impl;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.model.Fruit;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.GenerateReportService;
import core.basesyntax.strategy.TransactionStrategy;
import java.util.List;

public class GenerateReportServiceImpl implements GenerateReportService {
    private final TransactionStrategy transactionStrategy;
    private final FruitDao fruitDao;

    public GenerateReportServiceImpl(TransactionStrategy transactionStrategy, FruitDao fruitDao) {
        this.transactionStrategy = transactionStrategy;
        this.fruitDao = fruitDao;
    }

    @Override
    public void updateFruitQuantities(List<FruitTransaction> fruitTransactions) {
        for (FruitTransaction fruitTransaction : fruitTransactions) {
            Fruit fruit = fruitDao.get(fruitTransaction.getFruit());

            int newQuantity = transactionStrategy.get(fruitTransaction.getOperation())
                    .getTransaction(fruit, fruitTransaction.getQuantity());
            if (newQuantity > 0) {
                fruit.setQuantity(newQuantity);
                fruitDao.update(fruit);
            } else {
                throw new RuntimeException("Quantity " + fruit.getFruit() + " is negative");
            }
        }
    }
}
