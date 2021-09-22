package core.basesyntax.services;

import core.basesyntax.dto.Transaction;

public interface ParserService {
    Transaction parseData(String data);
}
