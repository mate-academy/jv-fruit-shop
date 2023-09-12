package core.basesyntax.strategy;

import core.basesyntax.dto.Transaction;

public interface Operation {
    int apply(Transaction transaction);
}
