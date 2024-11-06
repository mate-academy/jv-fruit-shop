package core.basesyntax.service.operation;

import core.basesyntax.db.FruitStorage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.model.FruitsForSale;

public class BalanceOperation implements OperationHandler {

    @Override
    public void updateDataBase(FruitTransaction transaction) {
        FruitsForSale fruitsForSale = new FruitsForSale();
        if (fruitsForSale.isNotForSale(transaction.getFruit())) {
            throw new RuntimeException("We don't sell such fruit: " + transaction.getFruit());
        }
        if (transaction.getQuantity() < 0) {
            throw new RuntimeException("The balance cannot be negative.");
        }
        FruitStorage.fruitStorage.put(transaction.getFruit(), transaction.getQuantity());
    }
}
