package core.basesyntax.reportService;

import core.basesyntax.storage.DateFruits;
import java.util.stream.Collectors;

public class ReportGeneratorImpl implements ReportGenerator {
    @Override
    public String getReport() {
        return "fruit,quantity" + "\n" + DateFruits.getAll().entrySet().stream()
                .map(element -> element.getKey() + "," + element.getValue())
                .collect(Collectors.joining("\n"));
    }
}
