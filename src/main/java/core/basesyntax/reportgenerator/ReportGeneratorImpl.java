package core.basesyntax.reportgenerator;

import core.basesyntax.storage.Storage;
import java.util.stream.Collectors;

public class ReportGeneratorImpl implements ReportGenerator {
    @Override
    public String getReport() {
        return "fruit,quantity\n" + Storage.getAllFruits().entrySet().stream()
                .map(entry -> entry.getKey() + "," + entry.getValue())
                .collect(Collectors.joining("\n"));
    }
}
