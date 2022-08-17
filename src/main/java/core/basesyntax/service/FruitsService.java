package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;
import java.util.List;

public interface FruitsService {
    String generateFruitsReport(List<FruitTransaction> fruitTransactionList);
}
