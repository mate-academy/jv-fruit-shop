package core.basesyntax.service;

import core.basesyntax.db.FruitStorage;
import core.basesyntax.model.FruitRecordDto;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AmountCalculatorImpl implements AmountCalculator {
    private final OperationStrategy operationStrategy;

    public AmountCalculatorImpl(OperationStrategy operationStrategy) {
        this.operationStrategy = operationStrategy;
    }

    @Override
    public Map<String, Integer> calculateDataForReport(List<FruitRecordDto> fruitRecordDtos) {
        for (FruitRecordDto fruitRecordDto : fruitRecordDtos) {
            int newAmount = operationStrategy.get(fruitRecordDto.getType())
                    .getAmount(fruitRecordDto, FruitStorage.fruitsDataBase);
            FruitStorage.fruitsDataBase.put(fruitRecordDto.getFruit(), newAmount);
        }
        return FruitStorage.fruitsDataBase;
    }
}
