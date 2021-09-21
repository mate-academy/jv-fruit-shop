package core.basesyntax.services;

import core.basesyntax.dto.Transaction;

public interface Parser {
    Transaction parseData(String data);
}
