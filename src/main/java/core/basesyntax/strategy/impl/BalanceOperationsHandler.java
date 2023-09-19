package core.basesyntax.strategy.impl;

import core.basesyntax.model.FruitDto;
import core.basesyntax.storage.Storage;
import core.basesyntax.strategy.OperationsHandler;

public class BalanceOperationsHandler implements OperationsHandler {
    @Override
    public void operation(FruitDto fruitDto) {
        checkInputBalance(fruitDto);
        Storage.STORAGE.put(fruitDto.getName(), fruitDto.getAmount());
    }

    private void checkInputBalance(FruitDto fruitDto) {
        if (fruitDto.getAmount() < 0) {
            throw new RuntimeException("Incorrect input data for " + fruitDto.getName()
                                        + ". Amount can't be negative.");
        }
    }
}
