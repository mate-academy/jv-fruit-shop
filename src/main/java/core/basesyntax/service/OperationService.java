package core.basesyntax.service;

import core.basesyntax.dao.StorageDao;
import core.basesyntax.model.FruitTransaction;
import java.util.List;

public interface OperationService {
    StorageDao processOperations(List<FruitTransaction> fruitTransactionList);
}
