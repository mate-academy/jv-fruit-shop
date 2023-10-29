package core.basesyntax.servise;

import core.basesyntax.model.FruitTransaction;
import java.util.List;

public interface FruitStockUpdater {
    void processTransactions(List<FruitTransaction> list);
}
