package core.basesyntax.service.impl;

import core.basesyntax.dto.FruitTransactionDto;
import core.basesyntax.exception.InvalidOperationException;
import core.basesyntax.model.Operation;
import core.basesyntax.service.DataValidator;
import core.basesyntax.service.OperationHandler;
import core.basesyntax.service.OperationStrategy;
import core.basesyntax.service.StrategyService;
import java.util.List;
import java.util.Map;

public class StrategyServiceImpl implements StrategyService, OperationStrategy {
    private static final DataValidator DATA_VALIDATOR = new DataValidatorImpl();
    private final Map<Operation, OperationHandler> operations;

    public StrategyServiceImpl(Map<Operation, OperationHandler> operations) {
        this.operations = operations;
    }

    @Override
    public void processData(List<FruitTransactionDto> fruitTransactionDtoList,
                            Map<Operation, OperationHandler> operationTypeList) {
        for (FruitTransactionDto fruitTransactionDto : fruitTransactionDtoList) {
            DATA_VALIDATOR.validate(fruitTransactionDto);
            getHandler(fruitTransactionDto).handle(fruitTransactionDto);
        }
    }

    @Override
    public OperationHandler getHandler(FruitTransactionDto fruitTransactionDto) {
        Operation operation = fruitTransactionDto.operation();
        var handler = operations.get(operation);
        if (handler == null) {
            throw new InvalidOperationException("Invalid operation: " + operation);
        }
        return operations.get(operation);
    }
}
