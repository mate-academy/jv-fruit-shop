package core.basesyntax.strategy;

import static core.basesyntax.db.Storage.fruitData;

import core.basesyntax.model.FruitTransaction;

public class SupplyOperationHandler implements OperationHandler {
    @Override
    public void process(FruitTransaction fruitTransaction) {
        if (fruitData.containsKey(fruitTransaction.getFruit())) {
            Integer fruitAmountInfo = fruitData.get(fruitTransaction.getFruit());
            fruitAmountInfo += fruitTransaction.getAmount();
            fruitData.replace(fruitTransaction.getFruit(),fruitAmountInfo);
        } else {
            fruitData.put(fruitTransaction.getFruit(), fruitTransaction.getAmount());
        }
    }
}
