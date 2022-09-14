package core.basesyntax.model;

import core.basesyntax.service.Operation;

public class FruitTransaction {
  private Operation operation;
  private Fruit fruit;
  private int quantity;

  public Operations getOperation() {
    return operation;
  }

  public void setOperation(Operations operation) {
    this.operation = operation;
  }

  public String getFruit() {
    return fruit;
  }

  public void setFruit(String fruit) {
    this.fruit = fruit;
  }

  public int getQuantity() {
    return quantity;
  }

  public void setQuantity(int quantity) {
    this.quantity = quantity;
  }
}