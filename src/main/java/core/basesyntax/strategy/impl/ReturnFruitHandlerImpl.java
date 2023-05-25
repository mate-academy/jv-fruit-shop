package core.basesyntax.strategy.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.FruitHandler;
import java.util.Map;

public class ReturnFruitHandlerImpl implements FruitHandler {
    @Override
    public void getActivity(FruitTransaction fruitTransaction) {
        for (Map.Entry<String, Integer> entry : Storage.getFruitsComposition().entrySet()) {
            if (entry.getKey().equals(fruitTransaction.getFruit())) {
                int newQuantity = entry.getValue() + fruitTransaction.getQuantity();
                entry.setValue(newQuantity);
            }
        }
    }
}
