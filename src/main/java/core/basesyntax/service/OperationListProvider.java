package core.basesyntax.service;

import core.basesyntax.operation.StoreOperation;
import java.util.List;

public interface OperationListProvider {
    List<StoreOperation> get(List<String> storageData);
}
