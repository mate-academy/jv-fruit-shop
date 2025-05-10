package core.basesyntax.dto;

import core.basesyntax.model.Operation;

public record FruitTransactionDto(
        Operation operation,
        String fruit,
        int quantity
) {
}
