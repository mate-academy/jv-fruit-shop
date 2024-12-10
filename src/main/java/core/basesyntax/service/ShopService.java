package core.basesyntax.service;

import core.basesyntax.FruitTransfer;
import core.basesyntax.Operation;
import core.basesyntax.OperationHandler;
import java.util.List;
import java.util.Map;

public interface ShopService {
    void process(List<FruitTransfer> transferList, Map<Operation, OperationHandler> handlers);
}
