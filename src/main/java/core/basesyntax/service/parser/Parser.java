package core.basesyntax.service.parser;

import core.basesyntax.dto.Transaction;

public interface Parser {
    Transaction parseLine(String line);
}
