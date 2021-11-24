package service.implementoOperation;

import service.OperationService;
import core.basesyntax.bd.Storage;
import core.basesyntax.model.Fruit;
import core.basesyntax.model.ParseLine;

public class OperationCreate implements OperationService {

    @Override
    public boolean operation(ParseLine line) {

        Fruit newFruit = new Fruit(line.getFruitName(), line.getQuantity());
        Storage.storage.add(newFruit);
    return true;
    }
}
