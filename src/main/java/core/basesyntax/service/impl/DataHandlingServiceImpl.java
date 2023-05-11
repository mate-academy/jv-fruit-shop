package core.basesyntax.service.impl;

import core.basesyntax.service.ConvertService;
import core.basesyntax.service.DataHandlingService;
import core.basesyntax.strategy.OperationService;
import core.basesyntax.strategy.OperationStrategy;
import java.util.List;

public class DataHandlingServiceImpl implements DataHandlingService {
    private final ConvertService convertService;
    private final OperationStrategy operationStrategy;

    public DataHandlingServiceImpl(ConvertService convertService,
                                   OperationStrategy operationStrategy) {
        this.convertService = convertService;
        this.operationStrategy = operationStrategy;
    }

    @Override
    public void processing(List<String> data) {
        data.stream()
                .map(convertService::convertToFruitTransaction)
                .forEach(curTransaction -> {
                    OperationService service =
                            operationStrategy.getOperationBySpecialMark(curTransaction);
                    service.calculate(curTransaction);
                });
    }
}
