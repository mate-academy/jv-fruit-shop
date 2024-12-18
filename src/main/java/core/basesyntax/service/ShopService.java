package core.basesyntax.service;

import core.basesyntax.models.FruitTransfer;
import core.basesyntax.models.Operation;
import core.basesyntax.strategy.OperationHandler;
import java.util.List;
import java.util.Map;

public interface ShopService {
    void process(List<FruitTransfer> transferList, Map<Operation, OperationHandler> handlers);
}
