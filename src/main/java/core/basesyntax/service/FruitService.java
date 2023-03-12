package core.basesyntax.service;

import core.basesyntax.service.impl.FruitTransaction;
import java.util.List;

public interface FruitService {
    void applyFruitTransactions(List<FruitTransaction> fruitTransaction);

    void createResultFile(String report, String filePath);
}
