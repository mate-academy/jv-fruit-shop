package core.basesyntax.service;

import core.basesyntax.FruitTransaction;
import java.util.List;

public interface CounterService {
    public void countFruits(List<FruitTransaction> transactionList);
}
