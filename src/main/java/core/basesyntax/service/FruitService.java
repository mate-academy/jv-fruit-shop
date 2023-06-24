package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;
import java.util.List;
import java.util.Map;

public interface FruitService {
    Map<String, String> calculateBalance(List<FruitTransaction> transaction);
}
