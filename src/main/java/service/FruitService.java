package service;

import core.basesyntax.FruitTransaction;
import java.util.List;

public interface FruitService {
    void process(List<FruitTransaction> fruitTransactions);
}

