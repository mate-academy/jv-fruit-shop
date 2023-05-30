package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;
import java.util.List;

public interface StoreService {
    void dataProcess(List<FruitTransaction> transactions);
}
