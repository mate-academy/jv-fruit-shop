package core.basesyntax.model.service;

import core.basesyntax.model.FruitTransaction;
import java.util.List;

public interface OperatorService {
    void operateTransactions(List<FruitTransaction> transactions);
}
