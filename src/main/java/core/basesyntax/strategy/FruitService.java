package core.basesyntax.strategy;

import core.basesyntax.model.Transaction;

public interface FruitService {
    Transaction add(Transaction transaction);

    Transaction remove(Transaction transaction);
}
