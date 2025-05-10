package core.basesyntax.model;

import core.basesyntax.service.Operation;

public record FruitTransaction(Operation operation, String fruit, int quantity) {
}
