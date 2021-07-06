package core.basesyntax.service;

import core.basesyntax.dto.Transaction;

public interface DataParser {
    Transaction parseData(String data);
}
