package core.basesyntax.impl;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.DataProcessingService;
import core.basesyntax.strategy.TransactionStrategy;
import java.util.List;

public class DataProcessingServiceImpl implements DataProcessingService {
    private final TransactionStrategy transactionStrategy;
    private final FruitDao fruitDao;

    public DataProcessingServiceImpl(FruitDao fruitDao, TransactionStrategy transactionStrategy) {
        this.transactionStrategy = transactionStrategy;
        this.fruitDao = fruitDao;
    }

    @Override
    public void updateDataStorage(List<FruitTransaction> fruitTransactions) {
        for (FruitTransaction fruitTransaction : fruitTransactions) {

            String fruitName = fruitTransaction.getFruit();
            int transactionQuantity = fruitTransaction.getQuantity();
            int oldQuantity = fruitDao.get(fruitName);

            int newQuantity = transactionStrategy.get(fruitTransaction.getOperation())
                    .getTransactionResult(oldQuantity, transactionQuantity);

            if (newQuantity < 0) {
                throw new RuntimeException("Quantity " + fruitName + " is negative");
            }
            fruitDao.update(fruitName, newQuantity);
        }
    }
}
