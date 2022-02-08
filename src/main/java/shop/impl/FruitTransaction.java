package shop.impl;

import shop.service.Operation;

public class FruitTransaction {
  private Operation operation;
  private String fruitName;
  private int quantity;

  public FruitTransaction(Operation operation, String fruitName, int quantity) {
    this.operation = operation;
    this.fruitName = fruitName;
    this.quantity = quantity;
  }

  public Operation getOperation() {
    return operation;
  }

  public String getFruitName() {
    return fruitName;
  }

  public int getQuantity() {
    return quantity;
  }

  @Override
  public String toString() {
    return "FruitTransaction{" +
            "operation=" + operation +
            ", fruitName='" + fruitName + '\'' +
            ", quantity=" + quantity +
            '}';
  }
}