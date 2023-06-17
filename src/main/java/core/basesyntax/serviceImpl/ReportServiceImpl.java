package core.basesyntax.serviceImpl;

import core.basesyntax.db.Storage;
import core.basesyntax.service.ReportService;
import java.util.Set;

public class ReportServiceImpl implements ReportService {
    private static final String TITLES = "fruit,quantity";
    private static final String COMMA_SEPARATOR = ",";

    @Override
    public String createReport() {
        Set<String> fruits = Storage.storage.keySet();
        StringBuilder builder = new StringBuilder(TITLES);
        builder.append(System.lineSeparator());
        for (String fruit : fruits) {
            builder.append(fruit).append(COMMA_SEPARATOR).append(Storage.storage.get(fruit))
                    .append(System.lineSeparator());
        }
        return builder.toString();
    }
}
