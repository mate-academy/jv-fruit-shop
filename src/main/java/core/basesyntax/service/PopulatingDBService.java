package core.basesyntax.service;

import core.basesyntax.models.FruitTransaction;
import java.util.List;

public interface PopulatingDBService {
    void prepareDB(List<FruitTransaction> transactionList);
}
