package core.basesyntax.service;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.model.Fruit;
import core.basesyntax.model.FruitTransaction;
import java.util.List;

public class FruitTransactionServiceImpl implements FruitTransactionService {
    private TransactionStrategy strategy;
    private FruitDao fruitDao;

    public FruitTransactionServiceImpl(TransactionStrategy strategy, FruitDao fruitDao) {
        this.strategy = strategy;
        this.fruitDao = fruitDao;
    }

    @Override
    public void process(List<FruitTransaction> fruitTransactions) {
        FruitService fruitService = new FruitServiceImpl(fruitDao);
        for (FruitTransaction transaction : fruitTransactions) {
            if (fruitDao.get(transaction.getFruit()) == null) {
                fruitService.createNewFruit(transaction.getFruit());
            }
            Fruit fruitOperation = fruitDao.get(transaction.getFruit());
            int fruitSummary = strategy
                    .getActivity(transaction.getOperation())
                    .process(transaction.getQuantity(), fruitOperation.getQuantity());
            fruitOperation = new Fruit(fruitSummary,transaction.getFruit());
            fruitDao.update(fruitOperation);
        }
    }
}
