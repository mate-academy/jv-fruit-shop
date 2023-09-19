package core.basesyntax.strategy.impl;

import core.basesyntax.model.FruitDto;
import core.basesyntax.storage.Storage;
import core.basesyntax.strategy.OperationsHandler;
import java.util.Map;

public class PurchaseOperationsHandler implements OperationsHandler {
    @Override
    public void operation(FruitDto fruitDto) {
        checkValue(fruitDto);
        for (Map.Entry<String, Integer> fruit : Storage.STORAGE.entrySet()) {
            if (fruit.getKey().equals(fruitDto.getName())) {
                checkBalance(fruitDto, fruit.getValue());
                fruit.setValue(fruit.getValue() - fruitDto.getAmount());
                break;
            }
        }
    }

    private void checkBalance(FruitDto fruitDto, int storageFruitAmount) {
        if (fruitDto.getAmount() > storageFruitAmount) {
            throw new RuntimeException("Purchase value isn't correct. "
                                        + "Storage haven't such amount of "
                                        + fruitDto.getName());
        }
    }

    private void checkValue(FruitDto fruitDto) {
        if (fruitDto.getAmount() < 0) {
            throw new RuntimeException("Purchase value can't be negative");
        }
    }
}
