package core.basesyntax.service.handlerservice;

import core.basesyntax.entity.FruitTransaction;
import core.basesyntax.service.handler.OperationHandler;

public interface HandlerService {
    OperationHandler getHandler(FruitTransaction.Operation activity);
}
