package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;
import java.util.List;
import java.util.Map;

public interface FruitsService {
    Map<String, Integer> processTransactions(List<FruitTransaction> transaction);
}
