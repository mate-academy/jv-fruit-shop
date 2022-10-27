package service.read.impl;

import java.util.Arrays;
import model.FruitTransaction;
import service.read.OperationTypeService;

public class OperationTypeServiceImpl implements OperationTypeService {
    private static final String NO_OPERATION_MESSAGE = "There is no such operation";

    @Override
    public FruitTransaction.Operation getOperation(String operation) {
        return Arrays.stream(FruitTransaction.Operation.values())
                .filter(o -> o.getOperation().equals(operation))
                .findFirst()
                .orElseThrow(() -> new RuntimeException(NO_OPERATION_MESSAGE));
    }
}
