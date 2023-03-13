package core.basesyntax.service.impl;

import core.basesyntax.model.Fruit;
import core.basesyntax.model.FruitTransfer;
import core.basesyntax.service.ConvertToFruitTransferService;

public class ConvertToFruitTransferServiceImpl implements ConvertToFruitTransferService {
    private static final int OPERATION = 0;
    private static final int FRUIT = 1;
    private static final int QUANTITY = 2;
    private static final String COMMA = ",";

    @Override
    public FruitTransfer toFruitTransfer(String readString) {
        String[] toFruitTransferArray = readString.split(COMMA);
        for (FruitTransfer.Operation operation : FruitTransfer.Operation.values()) {
            if (operation.getOperation().equals(toFruitTransferArray[OPERATION])) {
                return new FruitTransfer(operation,
                        new Fruit(toFruitTransferArray[FRUIT]),
                        Integer.parseInt(toFruitTransferArray[QUANTITY]));
            }
        }
        throw new RuntimeException("Can't convert to fruitTransfer");
    }
}
