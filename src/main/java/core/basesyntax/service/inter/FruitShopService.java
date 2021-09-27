package core.basesyntax.service.inter;

import core.basesyntax.model.FruitOperation;
import java.util.List;
import java.util.Map;

public interface FruitShopService {
    void updateStorageInfo(List<FruitOperation> operations,
                           Map<String, Operation> operationsHandlers);
}
