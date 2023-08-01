package core.basesyntax.service;

import core.basesyntax.model.Fruit;
import java.util.List;
import java.util.Map;

public interface ReportCreatorService {
    Map<String, Integer> createReport(List<Fruit> toReport);
}
