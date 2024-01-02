package core.basesyntax.services.operation_handlers;

import core.basesyntax.db.Storage;
import java.util.Map;

public class ReturnOperationHandler implements OperationHandler {
  public void returnFruit (String fruit, int returnedQuantity) {
    for(Map.Entry<String, Integer> fruitTypeAndAmount : Storage.fruitsTypeAndAmount.entrySet()) {
      if(fruitTypeAndAmount.getKey().equals(fruit)) {
        fruitTypeAndAmount.setValue(fruitTypeAndAmount.getValue() + returnedQuantity);
        break;
      }
    }
  }
}
