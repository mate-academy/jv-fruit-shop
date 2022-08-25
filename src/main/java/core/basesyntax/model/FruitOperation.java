package core.basesyntax.model;

public class FruitOperation {
  private String operation;
  private Fruit fruit;
  private int amount;

  public FruitOperation(){}

  public FruitOperation(String operation, Fruit fruit, int amount) {
    this.operation = operation;
    this.fruit = fruit;
    this.amount = amount;
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

  public void setOperation(String operation) {
    this.operation = operation;
  }

  public void setFruit(Fruit fruit) {
    this.fruit = fruit;
  }

  public void setAmount(int amount) {
    this.amount = amount;
  }

  @Override
  public String toString() {
    return "FruitOperation{" +
            "operation='" + operation + '\'' +
            ", fruit=" + fruit +
            ", amount=" + amount +
            '}';
  }
}