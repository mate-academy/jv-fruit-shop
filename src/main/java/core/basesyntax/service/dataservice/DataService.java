package core.basesyntax.service.dataservice;

import core.basesyntax.model.FruitTransaction;

public interface DataService {
    void processTransaction(FruitTransaction fruitTransaction);

    default void validateFruitTransaction(FruitTransaction fruitTransaction) {
        if (fruitTransaction.getQuantity() < 0) {
            throw new RuntimeException("Quantity in fruit transaction less than zero: "
                    + fruitTransaction.toString());
        }
    }
}
