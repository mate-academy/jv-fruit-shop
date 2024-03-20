package core.basesyntax.dto;

public record FruitTransactionDto(
        String operation,
        String fruit,
        int quantity
) {
}
