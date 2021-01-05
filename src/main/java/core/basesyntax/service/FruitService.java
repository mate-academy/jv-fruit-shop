package core.basesyntax.service;

import core.basesyntax.model.Fruits;
import core.basesyntax.model.Transaction;
import java.util.List;
import java.util.Map;

public interface FruitService {
    void chooseStrategy(List<Transaction> transaction);

    Map<Fruits, Integer> storage();
}
