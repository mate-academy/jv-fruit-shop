package core.basesyntax.handler;

import core.basesyntax.FruitTransaction;
import core.basesyntax.model.Product;

public class BalanceOperation implements OperationHandler{
    @Override
    public void transaction(FruitTransaction fruitTransaction, Product product) {
        product.setNumber(fruitTransaction.getNumber());
    }
}
