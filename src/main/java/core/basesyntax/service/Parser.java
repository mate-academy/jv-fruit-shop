package core.basesyntax.service;

import core.basesyntax.dto.Transaction;

public interface Parser {
    Transaction parseLine(String line);
}
