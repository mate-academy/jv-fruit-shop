package core.basesyntax.model;

public class FruitsTransaction {
  private final Operation operation;
  private final String fruit;
  private final int quantity;

  public FruitsTransaction(Operation operation, String fruit, int quantity) {
    this.operation = operation;
    this.fruit = fruit;
    this.quantity = quantity;
  }

  public Operation getOperation() {
    return operation;
  }

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

  @Override
  public String toString() {
    return "FruitsTransaction{" +
            "operation=" + operation +
            ", fruit='" + fruit + '\'' +
            ", quantity=" + quantity +
            '}';
  }
}

// цей клас буде зберігати данні з строки у вигляді
// дія.ім'я . кількість