package core.basesyntax.service;

import core.basesyntax.dto.Transaction;

public interface ParserData {
    Transaction parseData(String data);
}
