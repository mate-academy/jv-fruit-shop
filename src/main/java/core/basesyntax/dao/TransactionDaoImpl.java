package core.basesyntax.dao;

import core.basesyntax.db.Storage;
import core.basesyntax.model.Fruit;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.interfaces.strategy.TransactionStrategy;
import java.util.List;
import java.util.Map;

public class TransactionDaoImpl implements TransactionDao {
    private final TransactionStrategy transactionStrategy;

    public TransactionDaoImpl(TransactionStrategy transactionStrategy) {
        this.transactionStrategy = transactionStrategy;
    }

    @Override
    public void add(Fruit fruit, Integer quantity) {
        Storage.fruitStorage.put(new Fruit(fruit.getName()), quantity);
    }

    @Override
    public Integer get(String fruit) {
        return Storage.fruitStorage.get(fruit);
    }

    @Override
    public void addAll(List<FruitTransaction> fruitTransactions) {
        for (FruitTransaction transaction : fruitTransactions) {
            Fruit fruit = new Fruit(transaction.getFruit());
            Integer quantity = Storage.fruitStorage.get(fruit);
            Integer currentQuantity = transactionStrategy.getTransaction(transaction.getOperation())
                    .getCurrentQuantity(quantity, transaction.getQuantity());
            add(fruit, currentQuantity);
        }
    }

    @Override
    public String getAll() {
        StringBuilder builder = new StringBuilder();
        for (Map.Entry<Fruit, Integer> fruit : Storage.fruitStorage.entrySet()) {
            builder.append(String.format("%s %s%s", fruit.getKey().getName(),
                    fruit.getValue(),System.lineSeparator()));
        }
        return builder.toString();
    }
}
