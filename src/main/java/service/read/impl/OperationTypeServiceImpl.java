package service.read.impl;

import java.util.Arrays;
import java.util.Optional;
import model.FruitTransaction;
import service.read.OperationTypeService;

public class OperationTypeServiceImpl implements OperationTypeService {
    private static final String NO_OPERATION_MESSAGE = "There is no such operation";

    @Override
    public FruitTransaction.Operation getOperation(String value) {
        Optional<FruitTransaction.Operation> operation =
                Arrays.stream(FruitTransaction.Operation.values())
                        .filter(x -> x.getOperation().equals(value))
                        .findFirst();
        return operation
                .orElseThrow(() -> new RuntimeException(NO_OPERATION_MESSAGE));
    }
}
