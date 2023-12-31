package core.basesyntax.services.operation_handlers;

import core.basesyntax.db.Storage;
import java.util.Map;

public class SupplyOperationHandler implements OperationHandler {
  void supply(String fruit, int amountSupplied) {
    for(Map.Entry<String, Integer> fruitTypeAndAmount : Storage.fruitsTypeAndAmount.entrySet()) {
      if(fruitTypeAndAmount.getKey().equals(fruit)) {
        fruitTypeAndAmount.setValue(fruitTypeAndAmount.getValue() + amountSupplied);
        break;
      }
    }
  }
}
