package core.basesyntax.dto;

public record FruitTransactionDto (
    String operationType,
    String fruitName,
    int quantity
) {
}
