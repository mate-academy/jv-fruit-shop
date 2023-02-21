package core.basesyntax.service.handlerservice;

import core.basesyntax.entity.FruitTransaction;
import core.basesyntax.service.handler.OperationHandler;
import java.util.Map;

public class HandlerServiceImpl implements HandlerService {
    private final Map<FruitTransaction.Operation, OperationHandler> stringStrategyActivityMap;

    public HandlerServiceImpl(Map<FruitTransaction.Operation,
            OperationHandler> stringStrategyActivityMap) {
        this.stringStrategyActivityMap = stringStrategyActivityMap;
    }

    @Override
    public OperationHandler getHandler(FruitTransaction.Operation activity) {
        return stringStrategyActivityMap.get(activity);
    }
}
