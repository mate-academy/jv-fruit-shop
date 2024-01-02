package core.basesyntax.services.operation_handlers;

import core.basesyntax.db.Storage;
import java.util.Map;

public class PurchaseOperationHandler implements OperationHandler {
  public void purchase(String fruit, int purchasedQuantity) {
    for(Map.Entry<String, Integer> fruitTypeAndAmount : Storage.fruitsTypeAndAmount.entrySet()) {
      if(fruitTypeAndAmount.getKey().equals(fruit)) {
        fruitTypeAndAmount.setValue(fruitTypeAndAmount.getValue() - purchasedQuantity);
        break;
      }
    }
  }
}
