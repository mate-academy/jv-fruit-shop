package core.basesyntax.service.implementations;

import core.basesyntax.service.ReportCreator;
import core.basesyntax.storage.Storage;
import java.util.Map;

public class ReportCreatorImpl implements ReportCreator {

    @Override
    public String create() {
        StringBuilder reportString = new StringBuilder();
        reportString.append("fruit,quantity").append(System.lineSeparator());

        for (Map.Entry<String, Integer> entry : Storage.storage.entrySet()) {
            String fruit = entry.getKey();
            int quantity = entry.getValue();
            reportString.append(fruit).append(",").append(quantity).append(System.lineSeparator());
        }
        return reportString.toString();
    }
}
