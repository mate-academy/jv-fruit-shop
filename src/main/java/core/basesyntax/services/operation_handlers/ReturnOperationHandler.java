package core.basesyntax.services.operation_handlers;

import core.basesyntax.db.Storage;
import java.util.Map;

public class ReturnOperationHandler implements OperationHandler {
  void returnFruit (String fruit, int amountReturned) {
    for(Map.Entry<String, Integer> fruitTypeAndAmount : Storage.fruitsTypeAndAmount.entrySet()) {
      if(fruitTypeAndAmount.getKey().equals(fruit)) {
        fruitTypeAndAmount.setValue(fruitTypeAndAmount.getValue() + amountReturned);
        break;
      }
    }
  }
}
