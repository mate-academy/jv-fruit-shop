package core.basesyntax.data.processing;

import core.basesyntax.model.FruitTransaction;
import java.util.List;

public interface TransactionParser {
    List<FruitTransaction> parseTransactions(List<String> lines);
}
