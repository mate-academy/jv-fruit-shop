package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.FruitService;
import core.basesyntax.strategy.OperationService;
import core.basesyntax.strategy.impl.OperationStrategyImpl;
import java.util.List;

public class FruitServiceImpl implements FruitService {
    private final OperationStrategyImpl operationStrategyImpl;

    public FruitServiceImpl(OperationStrategyImpl operationStrategyImpl) {
        this.operationStrategyImpl = operationStrategyImpl;
    }

    @Override
    public void process(List<FruitTransaction> data) {
        data.stream()
                .forEach(curTransaction -> {
                    OperationService service =
                            operationStrategyImpl.getOperation(curTransaction.getOperation());
                    service.calculate(curTransaction);
                });
    }
}
