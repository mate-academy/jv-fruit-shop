package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;
import java.util.List;

public interface FruitDataCounter {
    List<String> fruits(List<FruitTransaction> fruitTransactions);
}
