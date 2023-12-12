package core.basesyntax.service.impl;

import core.basesyntax.model.Fruit;
import core.basesyntax.service.BalanceService;
import core.basesyntax.service.OperationsStrategy;
import java.util.List;

public class BalanceServiceImpl implements BalanceService {
    private OperationsStrategy dataOperationsStrategy;

    public BalanceServiceImpl(OperationsStrategy dataOperationsStrategy) {
        this.dataOperationsStrategy = dataOperationsStrategy;
    }

    @Override
    public void calculation(List<Fruit> fruits) {
        for (Fruit fruit : fruits) {
            dataOperationsStrategy.get(fruit.getTypeOperation()).fruitOperation(fruit);

        }
    }
}
