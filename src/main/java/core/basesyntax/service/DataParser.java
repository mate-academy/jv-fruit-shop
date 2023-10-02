package core.basesyntax.service;

import core.basesyntax.model.Operation;

public interface DataParser {
    Operation parse(String entry);
}
