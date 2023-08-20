package core.basesyntax.services;

import core.basesyntax.model.FruitTransaction;
import java.util.List;

public interface ProcessStoreService {
    boolean processAction(List<FruitTransaction> fruitTransactions);
}
