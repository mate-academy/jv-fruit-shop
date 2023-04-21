package core.basesyntax.strategy;

import static core.basesyntax.db.Storage.fruitData;

import core.basesyntax.model.FruitTransaction;

public class PurchaseOperationHandler implements OperationHandler {
    @Override
    public void process(FruitTransaction fruitTransaction) {
        if (fruitData.containsKey(fruitTransaction.getFruit())) {
            Integer fruitAmountInfo = fruitData.getOrDefault(fruitTransaction.getFruit(),
                    fruitTransaction.getAmount());
            fruitAmountInfo -= fruitTransaction.getAmount();
            if (fruitAmountInfo < 0) {
                throw new RuntimeException(fruitTransaction.getFruit()
                        + "balance can't be negative");
            }
            fruitData.replace(fruitTransaction.getFruit(), fruitAmountInfo);
        } else {
            fruitData.getOrDefault(fruitTransaction.getFruit(),
                    fruitTransaction.getAmount());
        }
    }
}
