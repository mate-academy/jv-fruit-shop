package core.basesyntax.service.report;

import core.basesyntax.model.FruitTransaction;
import java.util.List;

public interface TransactionService {
    void process(List<FruitTransaction> transactions);
}
