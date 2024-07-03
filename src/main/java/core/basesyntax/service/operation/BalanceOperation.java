package core.basesyntax.service.operation;

import core.basesyntax.dao.FruitTransactionDao;
import core.basesyntax.model.FruitTransaction;

public class BalanceOperation implements OperationHandler {
    private final FruitTransactionDao fruitTransactionDao;

    public BalanceOperation(FruitTransactionDao fruitTransactionDao) {
        this.fruitTransactionDao = fruitTransactionDao;
    }

    @Override
    public void recount(FruitTransaction transaction) {
        if (isNegative(transaction.getQuantity())) {
            throw new RuntimeException("Quantity can't be less than 0.");
        }
        fruitTransactionDao.add(transaction.getFruit(), transaction.getQuantity());
    }

    private boolean isNegative(int num) {
        return num < 0;
    }
}
