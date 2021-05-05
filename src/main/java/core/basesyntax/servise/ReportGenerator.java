package core.basesyntax.servise;

import core.basesyntax.model.Fruit;
import core.basesyntax.storage.Storage;
import java.util.Map;

public class ReportGenerator {
    private static final String COMA = ",";

    public String readData() {
        StringBuilder line = new StringBuilder();
        for (Map.Entry<Fruit, Integer> entry : Storage.getAll().entrySet()) {
            line.append(entry.getKey().getTypeOfFruit())
                    .append(COMA).append(entry.getValue())
                    .append(System.lineSeparator());
        }
        return line.toString();
    }
}
