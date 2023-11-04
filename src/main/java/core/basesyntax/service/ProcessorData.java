package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;
import java.util.List;

public interface ProcessorData {
    void processData(List<FruitTransaction> fruitTransactions);
}
