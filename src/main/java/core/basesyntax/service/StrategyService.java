package core.basesyntax.service;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.model.ParsedLineFromFileCsv;
import core.basesyntax.strategy.FruitWorkStrategy;
import java.util.List;

public interface StrategyService {
    void workWithStrategy(List<ParsedLineFromFileCsv> fileData,
                          FruitWorkStrategy fruitWork, FruitDao fruitDao);
}
