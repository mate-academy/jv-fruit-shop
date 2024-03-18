package core.basesyntax.service;

import core.basesyntax.model.Transaction;

public interface TransactionParser<T extends Transaction> {
    T parse(String rows);
}
