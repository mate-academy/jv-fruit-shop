package dto;

public record FruitTransactionDto(
        String operation,
        String fruitName,
        int quantity) {
}
