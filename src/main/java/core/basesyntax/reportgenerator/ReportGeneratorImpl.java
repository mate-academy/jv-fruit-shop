package core.basesyntax.reportgenerator;

import core.basesyntax.storage.Storage;

public class ReportGeneratorImpl implements ReportGenerator {
    @Override
    public String getReport() {
        StringBuilder sb = new StringBuilder();

        for (String fruit : Storage.getFruitStorage().keySet()) {
            sb.append(fruit)
                    .append(",")
                    .append(Storage.getFruitStorage().get(fruit))
                    .append(" ");
        }

        return sb.toString();
    }
}
