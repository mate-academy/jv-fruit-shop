package core.basesyntax.strategy.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.FruitHandler;
import java.util.Map;

public class PurchaseFruitHandlerImpl implements FruitHandler {
    @Override
    public void getActivity(FruitTransaction fruitTransaction) {
        for (Map.Entry<String, Integer> entry : Storage.getFruitStorage().entrySet()) {
            if (entry.getKey().equals(fruitTransaction.getFruit())) {
                validateTransactionQuantity(fruitTransaction, entry);
                int newQuantity = entry.getValue() - fruitTransaction.getQuantity();
                if (newQuantity < 0) {
                    throw new RuntimeException("Reserve of fruits shouldn't be less than 0");
                }
                entry.setValue(newQuantity);
            }
        }
    }

    private void validateTransactionQuantity(FruitTransaction fruitTransaction,
                                             Map.Entry<String, Integer> entry) {
        if (fruitTransaction.getQuantity() > entry.getValue()) {
            throw new RuntimeException("It is impossible to buy more fruit "
                    + "than is available in the store");
        }
    }
}
