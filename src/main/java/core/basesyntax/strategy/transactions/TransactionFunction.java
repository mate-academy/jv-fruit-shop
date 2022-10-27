package core.basesyntax.strategy.transactions;

import java.util.List;
import java.util.function.Function;

public interface TransactionFunction extends Function<List<String>,
        List<FruitTransaction>> {
}
