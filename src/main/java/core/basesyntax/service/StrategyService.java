package core.basesyntax.service;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.model.ParsedCsvLine;
import core.basesyntax.strategy.FruitWorkStrategy;
import java.util.List;

public interface StrategyService {
    void workWithStrategy(List<ParsedCsvLine> fileData,
                          FruitWorkStrategy fruitWork, FruitDao fruitDao);
}
