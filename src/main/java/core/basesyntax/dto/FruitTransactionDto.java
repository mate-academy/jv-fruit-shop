package core.basesyntax.dto;

import core.basesyntax.model.Operation;

public record FruitTransactionDto(
            Operation operationType,
            String fruitName,
            int quantity
) {
}
