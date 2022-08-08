package core.basesyntax.model;

public class FruitTransaction {
  private Operation operation;
  private String fruit;
  private int quantity;

  public FruitTransaction(Operation operation, String fruit, int quantity) {
    this.operation = operation;
    this.fruit = fruit;
    this.quantity = quantity;
  }

  public enum Operation {
    BALANCE("b"),
    SUPPLY("s"),
    PURCHASE("p"),
    RETURN("r");

    private String operation;

    Operation(String operation) {
      this.operation = operation;
    }

    public String getOperation() {
      return operation;
    }
  }
}