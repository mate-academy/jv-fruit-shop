package core.basesyntax.strategy.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.FruitHandler;
import java.util.Map;

public class SupplyFruitHandlerImpl implements FruitHandler {
    @Override
    public void getActivity(FruitTransaction fruitTransaction) {
        for (Map.Entry<String, Integer> entry : Storage.getFruitStorage().entrySet()) {
            if (entry.getKey().equals(fruitTransaction.getFruit())) {
                Integer newQuantity = entry.getValue() + fruitTransaction.getQuantity();
                entry.setValue(newQuantity);
            }
        }
    }
}
