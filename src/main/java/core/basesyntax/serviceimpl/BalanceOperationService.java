package core.basesyntax.serviceimpl;

import core.basesyntax.db.Storage;
import core.basesyntax.model.Fruit;
import core.basesyntax.service.OperationService;

public class BalanceOperationService implements OperationService {
    @Override
    public void calculateQuantity(Fruit fruit) {
       if (fruit.getFruit().equals("banana")){
           Storage.banana.setQuantity(fruit.getQuantity());
       } else if (fruit.getFruit().equals("apple")) {
           Storage.apple.setQuantity(fruit.getQuantity());
       }
    }
}
