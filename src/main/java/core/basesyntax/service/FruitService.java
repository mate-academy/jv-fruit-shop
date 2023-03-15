package core.basesyntax.service;

import core.basesyntax.FruitTransaction;
import java.util.List;

public interface FruitService {
    void chooseStrategy(List<FruitTransaction> transactionList);
}
