package core.basesyntax.service;

import core.basesyntax.strategy.FruitTransaction;
import java.util.List;

public interface TransferToDbService {
    void transfer(List<FruitTransaction> transactions);
}
