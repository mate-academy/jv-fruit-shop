package core.basesyntax.service;

import core.basesyntax.model.TypeOfFruit;
import java.util.Map;

public interface ReportContent {
    String generateReportContent(Map<TypeOfFruit, Integer> fruitServiceMap);
}
