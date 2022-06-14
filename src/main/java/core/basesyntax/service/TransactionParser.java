package core.basesyntax.service;

import core.basesyntax.model.ProductTransaction;

public interface TransactionParser {
    ProductTransaction parse(String line);
}
