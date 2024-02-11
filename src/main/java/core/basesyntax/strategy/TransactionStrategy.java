package core.basesyntax.strategy;

import java.util.Map;

public interface TransactionStrategy {
    Integer balanceUpdater(String fruitName, int quantity);
}
