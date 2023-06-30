package core.basesyntax.startagy;

import core.basesyntax.dto.Transaction;

public interface OperationHandler {
    int apply(Transaction transaction);
}
