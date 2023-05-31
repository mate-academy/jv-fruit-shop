package core.basesyntax.services.imps;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.services.FruitService;
import core.basesyntax.strategy.OperationHandler;
import java.util.List;
import java.util.Map;

public class FruitServiceImp implements FruitService {
    @Override
    public void store(List<FruitTransaction> transactions,
                      Map<FruitTransaction.Operation, OperationHandler> operationHandlerMap) {
        transactions
                .forEach(t -> operationHandlerMap
                        .get(t.getOperation()).calculate(t));
    }
}
