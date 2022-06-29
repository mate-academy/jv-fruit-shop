package core.basesyntax.service.impl;

import core.basesyntax.model.Transaction;
import core.basesyntax.service.FruitService;
import core.basesyntax.service.OperationService;
import java.util.List;

public class FruitServiceImpl implements FruitService {
    private final OperationService operationService;

    public FruitServiceImpl(OperationService operationService) {
        this.operationService = operationService;
    }

    @Override
    public void process(List<Transaction> transactions) {
        transactions.forEach(
                fruitTransaction -> operationService
                        .getHandler(fruitTransaction.getOperation())
                        .applyChanges(fruitTransaction));
    }
}
