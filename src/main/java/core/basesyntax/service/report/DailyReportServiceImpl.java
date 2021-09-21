package core.basesyntax.service.report;

import core.basesyntax.db.FruitStorage;
import core.basesyntax.model.Fruit;
import java.util.Map;

public class DailyReportServiceImpl implements DailyReportService {
    private static final String OUTPUT_FILE_HEADER = "fruit,quantity";

    @Override
    public String createReport() {
        StringBuilder builderReport = new StringBuilder();
        builderReport.append(OUTPUT_FILE_HEADER)
                .append(System.lineSeparator());
        for (Map.Entry<Fruit, Integer> entry :
                FruitStorage.fruitsDataBase.entrySet()) {
            builderReport.append(entry.getKey().getName())
                    .append(",")
                    .append(entry.getValue())
                    .append(System.lineSeparator());
        }
        return builderReport.toString();
    }
}
