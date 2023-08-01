package strategy;

import java.util.Map;
import service.impl.FruitTransaction;
import strategy.handler.Handler;

public class StrategyImpl implements Strategy {
    @Override
    public Handler getHandler(FruitTransaction.Operation operation,
                              Map<FruitTransaction.Operation, Handler> handlerMap) {
        return handlerMap.get(operation);
    }
}
