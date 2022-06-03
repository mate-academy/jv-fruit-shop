package core.basesyntax.services;

import core.basesyntax.model.FruitTransaction;
import java.util.List;

public interface BalanceService {
    void balance(List<FruitTransaction> transactions);
}
