package core.basesyntax.service.report;

import java.util.Map;

public interface ReportCreator {
    String FIRST_LINE = "fruit,quantity";
    String createReport(Map<String, Integer> fruitTypesAndQuantity);
}
