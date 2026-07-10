package core.basesyntax;

import java.util.stream.Collectors;

public class ReportGeneratorImpl implements ReportGenerator {
    @Override
    public String getReport() {
        return Storage.getFruits().entrySet().stream()
                .map(e -> e.getKey() + "," + e.getValue())
                .collect(Collectors.joining(System.lineSeparator(),
                        "fruit,quantity" + System.lineSeparator(), ""));
    }
}
