package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;
import java.util.List;

public interface TransferToStorage {
    void transfer(List<FruitTransaction> transactions);
}
