package core.basesyntax.service;

import core.basesyntax.model.TransactionDto;

public interface Parser {
    TransactionDto parseLine(String line);
}
