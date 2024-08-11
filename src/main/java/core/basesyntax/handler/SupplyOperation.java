package core.basesyntax.handler;

import core.basesyntax.FruitTransaction;
import core.basesyntax.model.Product;

public class SupplyOperation implements OperationHandler {
    @Override
    public void transaction(FruitTransaction fruitTransaction, Product product) {
        product.setNumber(product.getNumber() + fruitTransaction.getNumber());
    }
}
