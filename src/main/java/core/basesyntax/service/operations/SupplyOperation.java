package core.basesyntax.service.operations;

import core.basesyntax.dao.FruitStorage;
import core.basesyntax.model.FruitTransaction;
import java.math.BigDecimal;

public class SupplyOperation implements OperationHandler {
    @Override
    public void apply(FruitTransaction transaction) {
        String fruit = transaction.getFruit();
        BigDecimal quantityToAdd = transaction.getQuantity();
        BigDecimal currentQuantity = FruitStorage.storage.getOrDefault(fruit, BigDecimal.ZERO);

        FruitStorage.storage.put(fruit, currentQuantity.add(quantityToAdd));
    }
}
