package core.basesyntax.serviceimpl;

import core.basesyntax.db.Storage;
import core.basesyntax.service.ReportService;
import java.util.stream.Collectors;

public class ReportServiceImpl implements ReportService {
    private static final String FIRST_LINE = "fruit,quantity";

    @Override
    public String createReport() {
        return FIRST_LINE + Storage.fruitsStorage.entrySet().stream()
                .map(entry -> "\n" + entry.getKey() + "," + entry.getValue())
                .collect(Collectors.joining());
    }
}
