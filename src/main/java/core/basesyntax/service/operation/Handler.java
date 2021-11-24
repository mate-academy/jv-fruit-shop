package core.basesyntax.service.operation;

import core.basesyntax.model.TransactionDto;

public interface Handler {
    boolean apply(TransactionDto transaction);
}
