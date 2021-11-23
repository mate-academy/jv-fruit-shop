package core.basesyntax.service.impl;

import core.basesyntax.model.CsvLineDto;
import core.basesyntax.model.Operation;
import core.basesyntax.service.StrategyService;
import core.basesyntax.strategy.FruitWorkStrategy;
import java.util.List;

public class StrategyServiceImpl implements StrategyService {
    @Override
    public void getStrategy(List<CsvLineDto> fileData, FruitWorkStrategy fruitWork) {
        for (CsvLineDto dataLine : fileData) {
            Operation key = Operation.getKey(dataLine.getOperation());
            String fruitName = dataLine.getFruitName();
            int fruitNumber = Integer.parseInt(dataLine.getNumber());
            fruitWork.get(key).apply(fruitNumber, fruitName);
        }
    }
}
