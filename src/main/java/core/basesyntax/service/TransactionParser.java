package core.basesyntax.service;

import core.basesyntax.model.Fruit;
import core.basesyntax.model.Operation;

public interface TransactionParser {
    Operation getOperation (String line);
    Fruit getFruit (String line);
    Integer getQuantity (String line);
}
