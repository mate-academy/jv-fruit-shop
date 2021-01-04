package core.basesyntax.operations;

import core.basesyntax.service.Transaction;

public interface Action {
    boolean action(Transaction transactionDto);
}
