package core.basesyntax.handlers.impl;

import core.basesyntax.FruitTransaction;
import core.basesyntax.data.Storage;
import core.basesyntax.handlers.OperationHandler;

public class SupplyOperation implements OperationHandler {
    @Override
    public void apply(FruitTransaction transaction) {
        String nameFruit = transaction.getFruit();
        int current = Storage.getAssortment().get(nameFruit);
        int res = current + transaction.getQuantity();
        Storage.getAssortment().put(nameFruit, res);
    }
}
