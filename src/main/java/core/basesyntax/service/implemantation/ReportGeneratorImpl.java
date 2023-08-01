package core.basesyntax.service.implemantation;

import core.basesyntax.service.ReportGenerator;
import core.basesyntax.storage.Storage;
import java.util.Map;
import java.util.stream.Collectors;

public class ReportGeneratorImpl implements ReportGenerator {
    private static final String INFORMATION_LINE = "fruit,quantity\n";
    private static final String PUNCTUATION_MARK = ",";

    @Override
    public String generateReport() {
        return Storage.storage.entrySet().stream()
                .map(entry -> entry.getKey() + PUNCTUATION_MARK + entry.getValue())
                .collect(Collectors.joining(System.lineSeparator(), INFORMATION_LINE, ""));
    }
}
