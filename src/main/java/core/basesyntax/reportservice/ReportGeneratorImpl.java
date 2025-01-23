package core.basesyntax.reportservice;

import core.basesyntax.storage.DateFruits;
import java.util.stream.Collectors;

public class ReportGeneratorImpl implements ReportGenerator {
    private static final String FRUIT = "fruit";
    private static final String QUANTITY = "quantity";
    @Override
    public String getReport() {
        return FRUIT + "," + QUANTITY + "\n" + DateFruits.getAll().entrySet().stream()
                .map(element -> element.getKey() + "," + element.getValue())
                .collect(Collectors.joining("\n"));
    }
}
