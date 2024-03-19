package core.basesyntax.service.strategy.impl;

import core.basesyntax.dto.FruitTransactionDto;
import core.basesyntax.service.strategy.OperationHandler;

public class BalanceOperationHandler implements OperationHandler {
    @Override
    public void apply(FruitTransactionDto dto) {

    }

    @Override
    public boolean isApplicable(FruitTransactionDto dto) {
        return false;
    }
}
