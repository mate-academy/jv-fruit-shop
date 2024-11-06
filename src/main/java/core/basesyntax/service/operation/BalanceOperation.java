package core.basesyntax.service.operation;

import core.basesyntax.db.FruitStorage;
import core.basesyntax.model.FruitTransaction;

public class BalanceOperation implements OperationHandler {
    private static final String BANANA = "banana";
    private static final String APPLE = "apple";

    @Override
    public void updateDataBase(FruitTransaction transaction) {
        if (!transaction.getFruit().equals(BANANA) && !transaction.getFruit().equals(APPLE)) {
            throw new RuntimeException("We don't sell such fruit: " + transaction.getFruit());
        }
        if (transaction.getQuantity() < 0) {
            throw new RuntimeException("The balance cannot be negative.");
        }
        FruitStorage.fruitStorage.put(transaction.getFruit(), transaction.getQuantity());
    }
}
