package core.basesyntax.dto;

public class FruitDtoImpl implements FruitDto {
    private final String name;
    private final int quantity;
    private final String operation;

    public FruitDtoImpl(String operation, String name, int quantity) {
        this.name = name;
        this.quantity = quantity;
        this.operation = operation;
    }

    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getOperation() {
        return operation;
    }
}
