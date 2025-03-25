package core.basesyntax.reportgenerator;

import core.basesyntax.storage.Storage;
import java.util.stream.Collectors;

public class ReportGeneratorImpl implements ReportGenerator {
    private final static String HEADER = "fruit,quantity\n";
    @Override
    public String getReport() {
        return HEADER + Storage.getAllFruits().entrySet().stream()
                .map(entry -> entry.getKey() + "," + entry.getValue())
                .collect(Collectors.joining("\n"));
    }
}
