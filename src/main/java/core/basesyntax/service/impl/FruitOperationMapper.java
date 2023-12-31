package core.basesyntax.service.impl;

import core.basesyntax.model.Fruit;
import core.basesyntax.model.FruitOperation;
import core.basesyntax.service.Mapper;
import java.math.BigDecimal;
import javax.naming.OperationNotSupportedException;

public class FruitOperationMapper implements Mapper<FruitOperation> {
    private static final int OPERATION_INDEX = 0;
    private static final int FRUIT_NAME_INDEX = 1;
    private static final int QUANTITY_INDEX = 2;

    @Override
    public FruitOperation getMappedObject(String[] data) {
        return map(data);
    }

    private FruitOperation map(String[] data) {
        Fruit fruit = new Fruit(data[FRUIT_NAME_INDEX],
                new BigDecimal(Integer.parseInt(data[QUANTITY_INDEX])));
        try {
            return new FruitOperation(mapOperation(data[OPERATION_INDEX]), fruit);
        } catch (OperationNotSupportedException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    private FruitOperation.Operation mapOperation(String operation)
            throws OperationNotSupportedException {
        return switch (operation) {
            case "b" -> FruitOperation.Operation.BALANCE;
            case "s" -> FruitOperation.Operation.SUPPLY;
            case "p" -> FruitOperation.Operation.PURCHASE;
            case "r" -> FruitOperation.Operation.RETURN;
            default -> throw new OperationNotSupportedException(operation + "not supported");
        };
    }
}
