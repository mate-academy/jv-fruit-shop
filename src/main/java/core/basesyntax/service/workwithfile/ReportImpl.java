package core.basesyntax.service.workwithfile;

import core.basesyntax.db.Storage;
import core.basesyntax.model.Fruit;
import core.basesyntax.service.SaveDataToStorage;
import java.util.Map;

public class ReportImpl implements Report {
    private static final String TITLE = "fruit,quantity";

    @Override
    public String report(SaveDataToStorage saveDataToStorage) {
        StringBuilder reportBuilder = new StringBuilder();
        reportBuilder.append(TITLE).append(System.lineSeparator());
        for (Map.Entry<Fruit, Integer> entry : Storage.fruits.entrySet()) {
            reportBuilder.append(entry.getKey().getName())
                         .append(",")
                         .append(entry.getValue())
                         .append(System.lineSeparator());
        }
        return reportBuilder.toString().trim();
    }
}
