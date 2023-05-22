package core.basesyntax.service;

import core.basesyntax.strategy.FruitTransaction;
import java.util.List;

public interface TransferToDb {
    void transfer(List<FruitTransaction> transactions);
}
