package core.basesyntax.services.operation_handlers;

import core.basesyntax.db.Storage;
import java.util.Map;

public class PurchaseOperationHandler implements OperationHandler {
  void purchase(String fruit, int amountPurchased) {
    for(Map.Entry<String, Integer> fruitTypeAndAmount : Storage.fruitsTypeAndAmount.entrySet()) {
      if(fruitTypeAndAmount.getKey().equals(fruit)) {
        fruitTypeAndAmount.setValue(fruitTypeAndAmount.getValue() - amountPurchased);
        break;
      }
    }
  }
}
