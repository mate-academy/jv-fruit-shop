package core.basesyntax.servise;

import core.basesyntax.model.FruitTransaction;
import java.util.List;

public interface FruitTransactionProcessorService {
    String process(List<FruitTransaction> data);
}
