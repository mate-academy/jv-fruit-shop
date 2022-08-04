package core.basesyntax.transactionprocessor;

import core.basesyntax.model.FruitTransaction;
import java.util.List;

public interface TransactionConstructor {
    List<FruitTransaction> convert(List<String> lines);
}
