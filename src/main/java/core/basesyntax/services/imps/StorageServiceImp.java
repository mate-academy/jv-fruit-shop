package core.basesyntax.services.imps;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.services.StorageService;
import core.basesyntax.strategy.OperationHandler;
import java.util.List;
import java.util.Map;

public class StorageServiceImp implements StorageService {
    @Override
    public void store(List<FruitTransaction> transactions,
                      Map<FruitTransaction.Operation, OperationHandler> operationHandlerMap) {
        transactions
                .forEach(t -> operationHandlerMap
                        .get(t.getOperation()).calculate(t));
    }
}
