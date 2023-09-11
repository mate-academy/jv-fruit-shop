package core.basesyntax.service.impl;

import core.basesyntax.handler.OperationHandler;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.model.Operation;
import core.basesyntax.service.FruitService;
import java.util.List;
import java.util.Map;

public class FruitServiceImpl implements FruitService {
    private final Map<Operation, OperationHandler> handlerMap;

    public FruitServiceImpl(Map<Operation, OperationHandler> handlerMap) {
        this.handlerMap = handlerMap;
    }

    @Override
    public void manageTransactions(List<FruitTransaction> transactions) {
        transactions.forEach(t -> handlerMap.get(t.getOperation()).process(t));
    }
}
