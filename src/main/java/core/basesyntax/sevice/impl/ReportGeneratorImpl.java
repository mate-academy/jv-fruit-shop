package core.basesyntax.sevice.impl;

import core.basesyntax.db.FruitStorage;
import core.basesyntax.service.ReportGenerator;
import java.util.Map;

public class ReportGeneratorImpl implements ReportGenerator {
    private static final String REGEX_TO_SPLIT = ",";
    private static final String CONTENTS = "fruit, quantity";

    @Override
    public String createReport() {
        StringBuilder stringBuilder = new StringBuilder(CONTENTS + System.lineSeparator());
        for (Map.Entry<String, Integer> entry : FruitStorage.fruitRepository.entrySet()) {
            stringBuilder.append(entry.getKey())
                    .append(REGEX_TO_SPLIT)
                    .append(entry.getValue())
                    .append(System.lineSeparator());
        }
        return stringBuilder.toString();
    }
}
