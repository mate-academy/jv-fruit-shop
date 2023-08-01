package strategy;

import java.util.Map;
import service.impl.FruitTransaction;
import strategy.handler.Handler;

public interface Strategy {
    Handler getHandler(FruitTransaction.Operation operation,
                       Map<FruitTransaction.Operation, Handler> handlerMap);
}
