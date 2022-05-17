package core.basesyntax.servise;

import core.basesyntax.model.FruitTransaction;
import java.util.List;

public interface FruitTransactionProcessorService {
    void process(List<FruitTransaction> data);
}
