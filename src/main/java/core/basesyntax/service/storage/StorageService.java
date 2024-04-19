package core.basesyntax.service.storage;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.operation.OperationStrategy;

import java.util.List;

public interface StorageService {
    void transfer(List<FruitTransaction> fruits);
}
