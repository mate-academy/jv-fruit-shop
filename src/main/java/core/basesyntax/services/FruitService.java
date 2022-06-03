package core.basesyntax.services;

import core.basesyntax.model.FruitTransaction;
import java.util.List;

public interface FruitService {
    void addUniqueFruitsToStorage(List<FruitTransaction> transactions);

    List<FruitTransaction> getListOfTransactions(List<String> inputFromFile);
}
