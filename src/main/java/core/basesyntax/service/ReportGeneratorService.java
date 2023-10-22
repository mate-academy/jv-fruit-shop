package core.basesyntax.service;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.model.Fruit;
import java.util.List;
import java.util.Map;

public interface ReportGeneratorService {
    String BALANCE_CAN_T_BE_NEGATIVE = "Balance can't be negative for: ";

    List<String> generateReport(FruitDao dao);

    Map<Fruit, Integer> generateBalance(FruitDao dao);
}
