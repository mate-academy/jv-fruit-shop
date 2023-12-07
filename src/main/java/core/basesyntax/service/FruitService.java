package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;
import java.util.List;

public interface FruitService {
    void getOperation(List<FruitTransaction> transactionList);
}