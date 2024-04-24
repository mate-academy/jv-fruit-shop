package core.basesyntax.strategy;

import core.basesyntax.operation.Transaction;
import core.basesyntax.service.QuantityCounter;

public interface QuantityCounterStrategy {
    QuantityCounter get(Transaction operation);
}
