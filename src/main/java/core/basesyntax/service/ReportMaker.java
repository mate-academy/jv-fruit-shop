package core.basesyntax.service;

import core.basesyntax.model.Fruit;
import java.util.List;
import java.util.Map;

public interface ReportMaker {
    Map<String, Long> amountCalculator(List<Fruit> fruits);

    String makeReport(List<Fruit> fruits);
}
