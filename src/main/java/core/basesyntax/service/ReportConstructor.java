package core.basesyntax.service;

import core.basesyntax.model.Fruit;
import java.util.Map;

public interface ReportConstructor {
    String createReport(Map<Fruit, Integer> map);

}
