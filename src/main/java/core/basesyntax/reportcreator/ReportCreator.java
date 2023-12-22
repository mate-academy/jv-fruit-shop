package core.basesyntax.reportcreator;

import core.basesyntax.Operation;
import core.basesyntax.Storage;
import java.util.Arrays;
import java.util.Map;

public class ReportCreator {
    public String generateReport(Storage storage) {
        StringBuilder report = new StringBuilder("type,fruit,quantity\n");
        for (Map.Entry<String, Integer> entry : Storage.fruits.entrySet()) {
            report.append(Arrays.stream(Operation.values())
                            .map(Operation::toString).findFirst().get())
                    .append(",")
                    .append(entry.getKey())
                    .append(",")
                    .append(entry.getValue())
                    .append("\n"
                    );
        }
        return report.toString();
    }
}

