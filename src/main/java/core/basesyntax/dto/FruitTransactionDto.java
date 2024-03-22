package core.basesyntax.dto;

import core.basesyntax.service.strategy.Operation;

public record FruitTransactionDto(
        Operation operation,
        String fruitName,
        int quantity) {
}
