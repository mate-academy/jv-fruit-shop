package core.basesyntax.model;

public class FruitTransaction {
    private String fruitOperation;
    private Fruit fruit;
    private Integer amount;

    public FruitTransaction(String fruitOperation, Fruit fruit, Integer amount) {
        this.fruitOperation = fruitOperation;
        this.fruit = fruit;
        this.amount = amount;
    }

    public String getOperation() {
        return fruitOperation;
    }

    public void setOperation(String fruitOperation) {
        this.fruitOperation = fruitOperation;
    }

    public Fruit getFruit() {
        return fruit;
    }

    public void setFruit(Fruit fruit) {
        this.fruit = fruit;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }
}
