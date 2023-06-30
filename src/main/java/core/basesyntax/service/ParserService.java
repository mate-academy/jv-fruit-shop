package core.basesyntax.service;

import core.basesyntax.dto.Transaction;

public interface ParserService {
    Transaction parseLine(String line);
}
