package core.basesyntax.service;

import core.basesyntax.model.Fruit;
import java.util.Map;

public interface BalanceService {

    Map<Fruit, Integer> calculateBalance();
}
