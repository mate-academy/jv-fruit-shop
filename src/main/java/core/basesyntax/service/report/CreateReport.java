package core.basesyntax.service.report;

import java.util.Map;

public interface CreateReport {
    String FIRST_LINE = "fruit,quantity";
    String getDataForReport(Map<String, Integer> fruitTypesAndQuantity);
}
