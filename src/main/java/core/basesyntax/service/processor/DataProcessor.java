package core.basesyntax.service.processor;

import core.basesyntax.model.FruitTransaction;
import java.util.List;

public interface DataProcessor {

    String calculateData(List<FruitTransaction> fruitTransactionList);
}
