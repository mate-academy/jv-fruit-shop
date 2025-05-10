package core.basesyntax.strategy;

import core.basesyntax.service.QuantityCounter;
import core.basesyntax.transaction.Transaction;

public interface QuantityCounterStrategy {
    QuantityCounter get(Transaction operation);
}
