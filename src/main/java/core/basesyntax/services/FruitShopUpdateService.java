package core.basesyntax.services;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.handlers.OperationHandler;
import java.util.List;
import java.util.Map;

public interface FruitShopUpdateService<T> {
    void update(List<T> data,
                Map<FruitTransaction.OperationType, OperationHandler> map);
}
