package core.basesyntax.model;

public class TransactionDto {
    private final Operation operation;
    private final ShopItem shopItem;
    private final Integer quantity;

    public TransactionDto(Operation operation, ShopItem shopItem, Integer quantity) {
        this.operation = operation;
        this.shopItem = shopItem;
        this.quantity = quantity;
    }

    public Operation getOperation() {
        return operation;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public ShopItem getItem() {
        return shopItem;
    }
}
