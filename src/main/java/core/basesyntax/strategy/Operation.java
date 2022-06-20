package core.basesyntax.strategy;

import core.basesyntax.model.TransactionInfo;

public interface Operation {
    void handle(TransactionInfo fruitTransaction);
}
