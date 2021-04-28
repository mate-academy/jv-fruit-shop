package core.basesyntax.dto;

public class FruitDto {
    private String fruitName;
    private int quantity;

    public FruitDto(String fruitName, int quantity) {
        this.fruitName = fruitName;
        this.quantity = quantity;
    }

    public String getFruitName() {
        return fruitName;
    }

    public int getQuantity() {
        return quantity;
    }
}
