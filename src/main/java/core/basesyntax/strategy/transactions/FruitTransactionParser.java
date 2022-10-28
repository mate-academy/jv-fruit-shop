package core.basesyntax.strategy.transactions;

import java.util.List;

public interface FruitTransactionParser {
    List<FruitTransaction> parse(List<String> strings);
}
