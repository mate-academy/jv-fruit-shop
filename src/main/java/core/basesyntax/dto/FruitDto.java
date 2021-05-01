package core.basesyntax.dto;

public class FruitDto {
    private String fruitName;
    private int quantity;
    private String activity;

    public FruitDto(String fruitName, int quantity, String activity) {
        this.fruitName = fruitName;
        this.quantity = quantity;
        this.activity = activity;
    }

    public String getFruitName() {
        return fruitName;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getActivity() {
        return activity;
    }
}
