package core.basesyntax.dao;

import core.basesyntax.db.Storage;
import core.basesyntax.model.Fruit;
import core.basesyntax.model.FruitTransaction;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class FruitDaoImpl implements FruitDao {
    @Override
    public void putTransaction(final FruitTransaction transaction) {
        final Fruit fruit = transaction.getFruit();
        List<FruitTransaction> transactions = Storage.fruitTransactions.get(fruit);
        if (transactions == null) {
            transactions = new ArrayList<>();
        }
        transactions.add(transaction);
        Storage.fruitTransactions.put(fruit, transactions);
    }

    @Override
    public List<FruitTransaction> getTransactions(final Fruit fruit) {
        final List<FruitTransaction> fruitTransactions = Storage.fruitTransactions.get(fruit);
        if (Storage.fruitTransactions.isEmpty() || fruitTransactions == null) {
            return Collections.emptyList();
        }
        return fruitTransactions;
    }

    @Override
    public Set<Map.Entry<Fruit, List<FruitTransaction>>> getTransactions() {
        return Storage.fruitTransactions.entrySet();
    }

    @Override
    public void saveBalance(final Map<Fruit, Integer> balance) {
        Storage.fruitBalance.clear();
        Storage.fruitBalance.putAll(balance);
    }

    @Override
    public Map<Fruit, Integer> getBalance() {
        return Storage.fruitBalance;
    }

    @Override
    public void clear() {
        Storage.fruitTransactions.clear();
        Storage.fruitBalance.clear();
    }
}
