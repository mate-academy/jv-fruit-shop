package core.basesyntax.service.fruittransactionservice;

import core.basesyntax.model.FruitTransaction;
import java.util.List;

public interface FruitTransactionProcessor {
    public void makeDailyFruitsUpdate(List<FruitTransaction> fruitTransactionList);
}
