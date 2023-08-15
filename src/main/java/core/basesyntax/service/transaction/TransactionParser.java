package core.basesyntax.service.transaction;

import java.util.List;

public interface TransactionParser {
    List<FruitTransaction> getFruitTransaction(List<String> dataFromReport);
}
