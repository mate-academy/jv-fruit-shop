package core.basesyntax.servise;

import core.basesyntax.model.Fruit;
import core.basesyntax.storage.Storage;
import java.util.Map;

public class ReportGenerator {
    private static final String COMMA = ",";
    private static final String HEADER = "fruit,quantity";

    public String readData() {
        StringBuilder line = new StringBuilder();
        line.append(HEADER).append(System.lineSeparator());
        for (Map.Entry<Fruit, Integer> entry : Storage.getAll().entrySet()) {
            line.append(entry.getKey().getTypeOfFruit())
                    .append(COMMA).append(entry.getValue())
                    .append(System.lineSeparator());
        }
        return line.toString();
    }
}
