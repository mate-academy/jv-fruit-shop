package core.basesyntax.service.impl;

import core.basesyntax.service.GenerateStringToWrite;
import java.util.Map;

public class GenerateStringToWriteImpl implements GenerateStringToWrite {
    private static final String TITLE_FRUIT = "fruit";
    private static final String SEPARATOR = ",";
    private static final String TITLE_QUANTITY = "quantity";

    @Override
    public String stringToWrite(Map<String, Integer> fruits) {
        StringBuilder reportBuilder = new StringBuilder();
        reportBuilder.append(TITLE_FRUIT).append(SEPARATOR).append(TITLE_QUANTITY);
        for (Map.Entry<String, Integer> fruit : fruits.entrySet()) {
            reportBuilder.append(System.lineSeparator());
            reportBuilder.append(fruit.getKey()).append(SEPARATOR).append(fruit.getValue());
        }
        return reportBuilder.toString();
    }
}
