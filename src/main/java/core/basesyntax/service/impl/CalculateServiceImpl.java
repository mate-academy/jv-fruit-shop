package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.CalculateService;
import core.basesyntax.strategy.OperationHandlerImpl;
import java.util.List;

public class CalculateServiceImpl implements CalculateService {
    private final OperationHandlerImpl activity;

    public CalculateServiceImpl(OperationHandlerImpl activity) {
        this.activity = activity;
    }

    @Override
    public void calculate(List<FruitTransaction> transactions) {
        for (FruitTransaction transaction : transactions) {
            activity.getHandler(transaction.getOperation()).doActivity(transaction);
        }
    }
}
