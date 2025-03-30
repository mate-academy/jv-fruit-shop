package core.basesyntax.reportGenerator;

import core.basesyntax.storage.Storage;

public class ReportGeneratorImpl implements ReportGenerator {
    @Override
    public String getReport() {
        StringBuilder sb = new StringBuilder();

        for (String fruit : Storage.fruitStorage.keySet()) {
            sb.append(fruit)
                    .append(",")
                    .append(Storage.fruitStorage.get(fruit))
                    .append(" ");
        }

        return sb.toString();
    }
}
