package core.basesyntax.dto;

public class Dto {
    private String operation;
    private String fruit;
    private Integer amount;

    public Dto(String operation, String fruit, Integer amount) {
        this.operation = operation;
        this.fruit = fruit;
        this.amount = amount;
    }

    public String getOperation() {
        return operation;
    }

    public String getFruit() {
        return fruit;
    }

    public Integer getAmount() {
        return amount;
    }
}
