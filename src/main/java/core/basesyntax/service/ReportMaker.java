package core.basesyntax.service;

import core.basesyntax.model.Fruit;
import java.util.Map;

public interface ReportMaker {
    String makeReport(Map<Fruit, Integer> fruits);
}
