package core.basesyntax.services.imps;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.services.FruitService;
import core.basesyntax.strategy.OperationHandler;
import java.util.List;
import java.util.Map;

public class FruitServiceImp implements FruitService {
    private final Map<FruitTransaction.Operation, OperationHandler> operationStrategyMap;

    public FruitServiceImp(Map<FruitTransaction.Operation, OperationHandler> operationStrategyMap) {
        this.operationStrategyMap = operationStrategyMap;
    }

    @Override
    public void store(List<FruitTransaction> transactions) {
        transactions.forEach(t -> operationStrategyMap
                        .get(t.getOperation()).calculate(t));
    }
}
