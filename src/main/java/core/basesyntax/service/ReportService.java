package core.basesyntax.service;

import core.basesyntax.model.Fruit;
import java.util.Map;

public interface ReportService {
    String create(Map<Fruit, Integer> storage);
}
