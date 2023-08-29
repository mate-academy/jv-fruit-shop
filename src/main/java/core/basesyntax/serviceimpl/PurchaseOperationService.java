package core.basesyntax.serviceimpl;

import core.basesyntax.db.Storage;
import core.basesyntax.model.Fruit;
import core.basesyntax.service.OperationService;

public class PurchaseOperationService implements OperationService {
    @Override
    public void calculateQuantity(Fruit fruit) {
        if (fruit.getFruit().equals("banana")){
            Storage.banana.setQuantity(Storage.banana.getQuantity() - fruit.getQuantity());
        } else if (fruit.getFruit().equals("apple")) {
            Storage.apple.setQuantity(Storage.apple.getQuantity() - fruit.getQuantity());
        }
    }
}
