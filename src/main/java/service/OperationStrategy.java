package service;

import jdk.dynalink.Operation;
import model.FruitTransaction;

public interface OperationStrategy {
     OperationHandler get(FruitTransaction.Operation operation);
}
