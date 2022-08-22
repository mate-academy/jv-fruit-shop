package core.basesyntax.service.report;

import core.basesyntax.model.Fruit;
import core.basesyntax.model.FruitTransaction;
import java.util.List;
import java.util.Map;

public interface TransactionService {
    void process(List<FruitTransaction> transactions);
}
