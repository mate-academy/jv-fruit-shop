package core.basesyntax.service.calculationservice;

import core.basesyntax.entity.FruitTransaction;
import java.util.List;

public interface FruitService {
    void processTransactions(List<FruitTransaction> transactions);
}
