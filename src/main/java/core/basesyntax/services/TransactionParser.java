package core.basesyntax.services;

import core.basesyntax.dto.Transaction;

public interface TransactionParser {
    Transaction parse(String data);
}
