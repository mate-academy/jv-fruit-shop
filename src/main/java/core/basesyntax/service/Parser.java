package core.basesyntax.service;

import core.basesyntax.model.TransactionDto;

public interface Parser<T> {
    TransactionDto parseTo(String line);
}
