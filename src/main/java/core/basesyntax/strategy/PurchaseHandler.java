package core.basesyntax.strategy;

import static core.basesyntax.storage.FruitStorage.fruitStorage;

import core.basesyntax.storage.FruitTransaction;

public class PurchaseHandler implements OperationHandler {
    @Override
    public void handleTransaction(FruitTransaction transaction) {
        if (fruitStorage.containsKey(transaction.getFruit())) {
            int stockNewValue = fruitStorage.get(transaction.getFruit())
                    - transaction.getQuantity();
            if (stockNewValue < 0) {
                throw new RuntimeException("There is no required amount of fruit"
                        + transaction.getFruit());
            }
            fruitStorage.put(transaction.getFruit(), stockNewValue);
        }
    }
}
