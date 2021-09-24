package service.handler;

import db.Storage;
import java.util.Map;
import model.FruitOperation;
import service.inter.Operation;

public class SupplyHandler implements Operation {
    private final Map<String, Integer> fruitsQuantity = Storage.fruitsQuantity;

    @Override
    public void apply(FruitOperation operation) {
        Integer currentQuantity = fruitsQuantity.get(operation.getFruit());
        Integer updatedQuantity = currentQuantity + operation.getQuantity();
        fruitsQuantity.put(operation.getFruit(), updatedQuantity);
    }
}
