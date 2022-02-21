package core.basesyntax.service;

import core.basesyntax.models.FruitTransaction;
import java.util.List;

public interface PopulatingDbService {
    void prepareDB(List<FruitTransaction> transactionList);
}
