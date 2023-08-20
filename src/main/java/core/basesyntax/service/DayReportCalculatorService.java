package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;
import java.util.List;
import java.util.Map;

public interface DayReportCalculatorService {
    Map<String, Integer> reportCalculator(List<FruitTransaction> fruinTransactionList);
}
