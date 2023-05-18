package core.basesyntax.process;

import core.basesyntax.model.FruitTransaction;
import java.util.List;

public interface FruitDataProcess {
    void processFruitData(List<FruitTransaction> fruitTransactionList);
}
