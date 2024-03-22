package core.basesyntax.dto;

import core.basesyntax.enums.Operation;

public record ProductTransaction(Operation operation, String product, int quantity) {}
