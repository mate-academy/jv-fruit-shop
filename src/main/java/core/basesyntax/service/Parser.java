package core.basesyntax.service;

import core.basesyntax.model.Operation;

@FunctionalInterface
public interface Parser {
    Operation parse(String line);
}
