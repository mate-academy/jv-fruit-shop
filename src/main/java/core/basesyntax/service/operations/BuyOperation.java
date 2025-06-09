package core.basesyntax.service.operations;

import core.basesyntax.dao.FruitStorage;
import core.basesyntax.model.FruitTransaction;
import java.math.BigDecimal;

public class BuyOperation implements OperationHandler {
    @Override
    public void apply(FruitTransaction transaction) {
        String fruit = transaction.getFruit();
        BigDecimal quantityToBuy = transaction.getQuantity();
        BigDecimal currentQuantity = FruitStorage.storage.getOrDefault(fruit, BigDecimal.ZERO);

        if (currentQuantity.compareTo(quantityToBuy) < 0) {
            throw new RuntimeException("Not enough  " + fruit + " in stock. Available:  "
                    + currentQuantity);
        }
        FruitStorage.storage.put(fruit, currentQuantity.subtract(quantityToBuy));
    }
}
