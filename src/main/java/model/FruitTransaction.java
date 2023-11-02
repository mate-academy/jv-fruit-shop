package model;

import operation.OperationHandler;

public record FruitTransaction(OperationHandler operation, String fruit, int amount) {
}
