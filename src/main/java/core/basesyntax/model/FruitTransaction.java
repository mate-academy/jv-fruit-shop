package core.basesyntax.model;

import core.basesyntax.service.operations.Operation;

public class FruitTransaction {
  private Operation operation;
  private FruitE fruit;
  private int quantity;

  public Operation getOperation() {
    return operation;
  }

  public void setOperation(Operation operation) {
    this.operation = operation;
  }

  public FruitE getFruit() {
    return fruit;
  }

  public void setFruit(FruitE fruit) {
    this.fruit = fruit;
  }

  public int getQuantity() {
    return quantity;
  }

  public void setQuantity(int quantity) {
    this.quantity = quantity;
  }
}