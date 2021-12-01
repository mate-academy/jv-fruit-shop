package core.basesyntax.service.parser;

import core.basesyntax.dto.TransactionDto;

public interface Parser {
    TransactionDto parseLine(String line);
}
