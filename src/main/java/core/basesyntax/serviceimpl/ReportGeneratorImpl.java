package core.basesyntax.serviceimpl;

import core.basesyntax.db.Storage;
import core.basesyntax.service.ReportGenerator;
import java.util.Map;

public class ReportGeneratorImpl implements ReportGenerator {

    private static final String FIRST_LINE = "fruit,quantity";
    private static final String COMA = ",";

    @Override
    public String getReport() {
        StringBuilder report = new StringBuilder();
        report.append(FIRST_LINE).append(System.lineSeparator());
        Map<String, Integer> currentStorage = Storage.getAll();
        if (currentStorage != null && !currentStorage.isEmpty()) {
            currentStorage.forEach((fruit, quantity) ->
                    report.append(fruit)
                            .append(COMA)
                            .append(quantity)
                            .append(System.lineSeparator())
            );
        }
        return report.toString();
    }
}
