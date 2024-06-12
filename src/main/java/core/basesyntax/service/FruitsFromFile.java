package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;
import java.util.List;

public interface FruitsFromFile {
    List<String> getFruitsFromFile(List<FruitTransaction> fruitTransactions);
}
