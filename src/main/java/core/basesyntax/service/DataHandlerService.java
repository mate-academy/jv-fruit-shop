package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;
import java.util.List;

public interface DataHandlerService {
    void handleData(List<FruitTransaction> fruitTransactions);
}
