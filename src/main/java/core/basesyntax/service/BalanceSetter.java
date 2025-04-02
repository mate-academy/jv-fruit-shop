package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;
import java.util.List;

public interface BalanceSetter {
    void setBalance(List<FruitTransaction> fruitTransactions);
}
