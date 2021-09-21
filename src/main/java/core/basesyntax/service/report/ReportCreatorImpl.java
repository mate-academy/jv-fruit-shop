package core.basesyntax.service.report;

import core.basesyntax.db.Storage;
import core.basesyntax.model.Fruit;
import java.util.Map;

public class ReportCreatorImpl implements Report {

    @Override
    public String createReport() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("fruit,quantity")
                .append(System.lineSeparator());
        for (Map.Entry<Fruit, Integer> entry : Storage.fruitStorage.entrySet()) {
            stringBuilder.append(entry.getKey().getFruit())
                    .append(",")
                    .append(entry.getValue())
                    .append(System.lineSeparator());
        }
        return stringBuilder.toString();
    }
}
