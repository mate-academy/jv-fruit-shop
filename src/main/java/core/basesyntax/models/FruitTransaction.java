package core.basesyntax.models;

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

    private String code;

    Operation(String code) {
      this.code = code;
    }

    public String getCode() {
      return code;
    }
  }
}