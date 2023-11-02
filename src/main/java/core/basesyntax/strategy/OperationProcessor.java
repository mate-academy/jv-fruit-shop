package core.basesyntax.strategy;

import core.basesyntax.data.FruitTransaction;
import core.basesyntax.data.Stock;
import java.util.List;

public interface OperationProcessor {
    Stock process(List<FruitTransaction> fruitTransactionsList);
}
