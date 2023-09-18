package core.basesyntax.servise;

import core.basesyntax.FruitTransaction;
import java.util.List;

public interface FruitStockUpdater {
    void processTransactions(List<FruitTransaction> list);
}
