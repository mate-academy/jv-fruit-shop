package service.read.impl;

import java.util.Arrays;
import model.FruitTransaction;
import service.read.OperationMapper;

public class OperationMapperImpl implements OperationMapper {

    @Override
    public FruitTransaction.Operation mapToOperation(String value) {
        return Arrays.stream(FruitTransaction.Operation.values())
                .filter(x -> x.getOperation().equals(value))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("There is no such operation"));
    }
}
