package core.basesyntax.dao;

import core.basesyntax.db.Storage;
import core.basesyntax.model.Fruit;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.interfaces.strategy.TransactionStrategy;
import core.basesyntax.service.transactions.TransactionStrategyImpl;
import java.util.List;
import java.util.Map;

public class TransactionDaoImpl implements TransactionDao {
    private static final TransactionStrategy transactionStrategy =
            new TransactionStrategyImpl();

    @Override
    public void add(Fruit fruit, Integer quantity) {
        Storage.fruitsStorage.put(new Fruit(fruit.getName()), quantity);
    }

    @Override
    public Integer get(String fruit) {
        return Storage.fruitsStorage.get(fruit);
    }

    @Override
    public void addAll(List<FruitTransaction> fruitTransactions) {
        for (FruitTransaction transaction : fruitTransactions) {
            Fruit fruit = new Fruit(transaction.getFruit());
            Integer quantity = Storage.fruitsStorage.get(fruit);
            Integer currentQuantity = transactionStrategy.getTransaction(transaction.getOperation())
                    .getCurrentQuantity(quantity, transaction.getQuantity());
            add(fruit, currentQuantity);
        }
    }

    @Override
    public String getAll() {
        StringBuilder builder = new StringBuilder();
        for (Map.Entry<Fruit, Integer> fruit : Storage.fruitsStorage.entrySet()) {
            builder.append(fruit.getKey().getName())
                    .append(" ").append(fruit.getValue()).append(System.lineSeparator());
        }
        return builder.toString();
    }
}
