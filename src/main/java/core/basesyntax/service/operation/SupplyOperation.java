package core.basesyntax.service.operation;

import core.basesyntax.db.FruitStorage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.model.FruitsForSale;
import java.util.Map;

public class SupplyOperation implements OperationHandler {
    @Override
    public void updateDataBase(FruitTransaction transaction) {
        FruitsForSale fruitsForSale = new FruitsForSale();
        if (fruitsForSale.isNotForSale(transaction.getFruit())) {
            throw new RuntimeException("We don't sell such fruit: " + transaction.getFruit());
        }
        if (FruitStorage.fruitStorage.get(transaction.getFruit()) == null) {
            throw new RuntimeException("First you need to enter the balance of "
                    + transaction.getFruit() + " under the code 'b'");
        }
        for (Map.Entry<String, Integer> entry : FruitStorage.fruitStorage.entrySet()) {
            if (transaction.getFruit().equals(entry.getKey())) {
                entry.setValue(entry.getValue() + transaction.getQuantity());
            }
        }
    }
}
