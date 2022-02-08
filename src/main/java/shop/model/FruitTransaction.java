package shop.model;

public class FruitTransaction {
  private Operation operation;
  private String fruit;
  private int quantity;

  // getters, setters, ...
  
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