package core.basesyntax.service.impl;

import core.basesyntax.dto.FruitTransactionDto;
import core.basesyntax.exception.InvalidOperationException;
import core.basesyntax.service.DataValidator;
import core.basesyntax.service.OperationHandler;
import core.basesyntax.service.OperationStrategy;
import core.basesyntax.service.StrategyService;
import java.util.List;
import java.util.Map;

public class StrategyServiceImpl implements StrategyService, OperationStrategy {
    private static final DataValidator DATA_VALIDATOR = new DataValidatorImpl();
    private final Map<String, OperationHandler> operations;

    public StrategyServiceImpl(Map<String, OperationHandler> operations) {
        this.operations = operations;
    }

    @Override
    public void processData(List<FruitTransactionDto> fruitTransactionDtoList,
                            Map<String, OperationHandler> operationTypeList) {
        for (FruitTransactionDto fruitTransactionDto : fruitTransactionDtoList) {
            DATA_VALIDATOR.validate(fruitTransactionDto);
            getHandlers(fruitTransactionDto).handle(fruitTransactionDto);
        }
    }

    @Override
    public OperationHandler getHandlers(FruitTransactionDto fruitTransactionDto) {
        String code = fruitTransactionDto.operation();
        var handler = operations.get(code);
        if (handler == null) {
            throw new InvalidOperationException("Invalid operation: " + code);
        }
        return operations.get(code);
    }
}
