package core.basesyntax.strategy;

import core.basesyntax.model.FruitTransaction;

public interface OperationHandler {
  public void calculateAndAddToStorage(FruitTransaction transaction);
}
