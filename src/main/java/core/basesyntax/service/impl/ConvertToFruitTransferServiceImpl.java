package core.basesyntax.service.impl;

import core.basesyntax.model.Fruit;
import core.basesyntax.model.FruitTransfer;
import core.basesyntax.service.ConvertToFruitTransferService;

public class ConvertToFruitTransferServiceImpl implements ConvertToFruitTransferService {
    @Override
    public FruitTransfer toFruitTransfer(String readString) {
        String[] toFruitTransferArray = readString.replace(" ", "").split(",");
        for (FruitTransfer.Operation operation : FruitTransfer.Operation.values()) {
            if (operation.getOperation().equals(toFruitTransferArray[0])) {
                return new FruitTransfer(operation,
                        new Fruit(toFruitTransferArray[1]),
                        Integer.parseInt(toFruitTransferArray[2]));
            }
        }
        return null;
    }
}
