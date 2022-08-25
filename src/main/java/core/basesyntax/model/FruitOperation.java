package core.basesyntax.model;

public class FruitOperation {
  private String operation;
  private Fruit fruit;
  private int amount;

  public FruitOperation(String operation, Fruit fruit, int quantity) {
    this.operation = operation;
    this.fruit = fruit;
    this.amount = quantity;
  }

  public String getOperation() {
    return operation;
  }

  public Fruit getFruit() {
    return fruit;
  }

  public int getAmount() {
    return amount;
  }
}