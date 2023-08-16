package core.basesyntax.service.report;

import java.util.Map;

public interface ReportCreator {
    String FIRST_LINE = "fruit,quantity";
    String getDataForReport(Map<String, Integer> fruitTypesAndQuantity);
}
