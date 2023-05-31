package core.basesyntax.services.imps;

import core.basesyntax.Storage;
import core.basesyntax.services.ReportService;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ReportServiceImp implements ReportService {
    private static final String COMA = ",";

    @Override
    public String createReportString() {
        return Stream.concat(
                Stream.of("fruit,quantity"),
                Storage.fruitInventory.entrySet().stream()
                        .map(e -> e.getKey() + COMA + e.getValue())
        ).collect(Collectors.joining(System.lineSeparator()));
    }
}
