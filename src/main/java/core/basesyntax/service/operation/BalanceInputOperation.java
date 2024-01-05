package core.basesyntax.service.operation;

import core.basesyntax.dao.FruitTransactionDao;
import core.basesyntax.model.FruitTransaction;

public class BalanceInputOperation implements InputTransaction {

    private final FruitTransactionDao fruitTransactionDao;

    public BalanceInputOperation(FruitTransactionDao fruitTransactionDao) {
        this.fruitTransactionDao = fruitTransactionDao;
    }

    @Override
    public void process(FruitTransaction fruitTransaction) {
        Integer quantity = fruitTransactionDao.get(fruitTransaction);
        if (quantity != null) {
            fruitTransaction.setQuantity(quantity + fruitTransaction.getQuantity());
        }
        fruitTransactionDao.add(fruitTransaction);
    }
}
