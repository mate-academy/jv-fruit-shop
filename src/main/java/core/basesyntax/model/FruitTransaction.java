package core.basesyntax.model;

import core.basesyntax.service.OperationService;

import java.util.Arrays;

public class FruitTransaction {
  private Operation operation;
  private String fruit;
  private int quantity;

  public Operation getOperation() {
    return operation;
  }

  public String getFruit() {
    return fruit;
  }

  public int getQuantity() {
    return quantity;
  }

  public void setOperation(Operation operation) {
    this.operation = operation;
  }

  public void setFruit(String fruit) {
    this.fruit = fruit;
  }

  public void setQuantity(int quantity) {
    this.quantity = quantity;
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

    public static Operation getOperationByCode(String code) {
      for (Operation operation : Operation.values()) {
        if (operation.getCode().equals(code)) {
          return operation;
        }
      }
      throw new RuntimeException("This operation is unavailable" + code);
    }
  }
}