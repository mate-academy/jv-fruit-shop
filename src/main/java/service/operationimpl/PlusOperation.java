package service.operationimpl;

import core.basesyntax.bd.Storage;
import core.basesyntax.model.Fruit;
import core.basesyntax.model.ParseLine;
import service.OperationService;

public class PlusOperation implements OperationService {
    @Override
    public boolean operation(ParseLine line) {
        for (Fruit storageFruit: Storage.storage) {
            if (storageFruit.getName().equals(line.getFruitName())) {
                int newNumber = storageFruit.getNumber() + line.getQuantity();
                storageFruit.setNumber(newNumber);
            }
        }
        return true;
    }
}
