package core.basesyntax.strategy.impl;

import core.basesyntax.model.FruitDto;
import core.basesyntax.storage.Storage;
import core.basesyntax.strategy.OperationsHandler;
import java.util.Map;

public class SupplyOperationsHandler implements OperationsHandler {
    @Override
    public void operation(FruitDto fruitDto) {
        checkValue(fruitDto);
        for (Map.Entry<String, Integer> fruit : Storage.STORAGE.entrySet()) {
            if (fruit.getKey().equals(fruitDto.getName())) {
                fruit.setValue(fruit.getValue() + fruitDto.getAmount());
                break;
            }
        }
    }

    private void checkValue(FruitDto fruitDto) {
        if (fruitDto.getAmount() < 0) {
            throw new RuntimeException("Supply value can't be negative");
        }
    }
}
