package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;
import java.util.List;

public interface ProcessDataService {
    void processData(List<FruitTransaction> fruitTransactions);
}
