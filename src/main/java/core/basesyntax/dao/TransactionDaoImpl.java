package core.basesyntax.dao;

import core.basesyntax.db.Storage;
import core.basesyntax.model.Fruit;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.interfaces.strategy.TransactionStrategy;
import core.basesyntax.service.transactions.TransactionStrategyImpl;

import java.util.List;

public class TransactionDaoImpl implements TransactionDao {
    private static final TransactionStrategy transactionStrategy =
            new TransactionStrategyImpl();

    @Override
    public void addFruits(Fruit fruit, Integer quantity) {
        Storage.fruitsStorage.put(new Fruit(fruit.getName()), quantity);
    }

    @Override
    public Integer getFruits(String fruit) {
        return Storage.fruitsStorage.get(fruit);
    }

    @Override
    public void addAll(List<FruitTransaction> fruitTransactions) {
        for (FruitTransaction transaction : fruitTransactions) {
            Fruit fruit = new Fruit(transaction.getFruit());
            Integer quantity = Storage.fruitsStorage.get(fruit);
            Integer currentQuantity = transactionStrategy.getTransaction(transaction.getOperation())
                    .getCurrentQuantity(quantity, transaction.getQuantity());
            addFruits(fruit, currentQuantity);
        }
    }
}
