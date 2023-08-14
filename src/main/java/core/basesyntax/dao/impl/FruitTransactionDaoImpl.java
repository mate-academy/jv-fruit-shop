package core.basesyntax.dao.impl;

import core.basesyntax.dao.FruitTransactionDao;
import core.basesyntax.db.FruitTransactionsStorage;
import core.basesyntax.model.FruitTransaction;
import java.math.BigDecimal;
import java.util.List;

public class FruitTransactionDaoImpl implements FruitTransactionDao {
    @Override
    public void add(FruitTransaction fruitTransaction) {
        FruitTransactionsStorage.fruitTransactions.add(fruitTransaction);
    }

    @Override
    public FruitTransaction get(String fruitName, BigDecimal quantity) {
        return FruitTransactionsStorage.fruitTransactions.stream()
                .filter(fruitTransaction ->
                        fruitTransaction.getFruitName().equals(fruitName)
                                && fruitTransaction.getQuantity().equals(quantity))
                .findFirst().orElse(null);
    }

    @Override
    public List<FruitTransaction> getAll() {
        return FruitTransactionsStorage.fruitTransactions;
    }
}
