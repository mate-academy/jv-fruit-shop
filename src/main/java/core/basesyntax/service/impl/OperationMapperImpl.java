package core.basesyntax.service.impl;

import core.basesyntax.exeption.OperationNotFoundExeption;
import core.basesyntax.model.Transaction;
import core.basesyntax.service.OperationMapper;
import java.util.Arrays;
import java.util.Optional;

public class OperationMapperImpl implements OperationMapper {
    @Override
    public Transaction.Operation mapToEnumValue(String operationFromFile) {
        Optional<Transaction.Operation> optionalOperation =
                Arrays.stream(Transaction.Operation.values())
                        .filter(o -> o.getOperation().equals(operationFromFile))
                        .findFirst();
        return optionalOperation.orElseThrow(()
                -> new OperationNotFoundExeption("Unknown operation " + operationFromFile));
    }
}
