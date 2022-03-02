package core.basesyntax.service;

import core.basesyntax.dto.Transaction;

public interface Parser {
    Transaction parseData(String data);
}
