package core.basesyntax.service.impl;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.model.Operation;
import core.basesyntax.model.ParsedCsvLine;
import core.basesyntax.service.StrategyService;
import core.basesyntax.strategy.FruitWorkStrategy;
import java.util.List;

public class StrategyServiceImpl implements StrategyService {
    @Override
    public void workWithStrategy(List<ParsedCsvLine> fileData, FruitWorkStrategy fruitWork,
                                 FruitDao fruitDao) {
        for (ParsedCsvLine dataLine : fileData) {
            Operation key = Operation.getKey(dataLine.getAction());
            String fruitName = dataLine.getFruitName();
            int fruitNumber = Integer.parseInt(dataLine.getNumber());
            fruitWork.get(key).workWithFruitInStorage(fruitNumber, fruitName, fruitDao);
        }
    }
}
