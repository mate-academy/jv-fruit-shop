package core.basesyntax.service;

import core.basesyntax.model.Transaction;

public interface Parser {
    Transaction parseLine(String line);
}
