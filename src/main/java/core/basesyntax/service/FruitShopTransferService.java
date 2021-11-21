package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.operationhandler.Operation;
import core.basesyntax.service.operationhandler.OperationHandler;
import java.util.List;
import java.util.Map;

public interface FruitShopTransferService {
    void updateStorageInfo(List<FruitTransaction> fruitStorages,
                                  Map<Operation, OperationHandler> operationType);
}
