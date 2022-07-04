package core.basesyntax.service;

import core.basesyntax.model.Fruit;
import java.util.List;
import java.util.Map;

public interface ShiftReportService {
    List<String> reportMaker(Map<Fruit, Integer> shiftReport);
}
