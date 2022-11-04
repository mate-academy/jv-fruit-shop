package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;
import java.util.List;

public interface MakerTransaction {
    void doTransactions(List<FruitTransaction> transactions);
}
