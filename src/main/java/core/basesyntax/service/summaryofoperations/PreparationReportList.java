package core.basesyntax.service.summaryofoperations;

import core.basesyntax.db.FruitStorage;
import java.util.Map;

public class PreparationReportList {
    private static final String TITLE = "fruit,quantity\n";
    private static final String DELIMITER = ",";

    public String reportPreparation() {
        Map<String, Integer> reportMap = FruitStorage.fruitsStorage;
        StringBuilder reportString = new StringBuilder(TITLE);
        for (Map.Entry<String, Integer> entry : reportMap.entrySet()) {
            reportString.append(entry.getKey()).append(DELIMITER).append(entry.getValue())
                    .append(System.lineSeparator());
        }
        return reportString.toString();
    }
}
