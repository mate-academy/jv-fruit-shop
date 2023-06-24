package service.impl;

import db.FruitStorage;
import java.util.Map;
import service.ReportGenerator;

public class ReportGeneratorImpl implements ReportGenerator {
    private static final String FIELD_NAMES = "fruit,quantity";

    @Override
    public String generate() {
        StringBuilder stringBuilder = new StringBuilder(FIELD_NAMES);
        for (Map.Entry<String, Integer> fruitBalance : FruitStorage.fruits.entrySet()) {
            stringBuilder.append(System.lineSeparator())
                    .append(fruitBalance.getKey())
                    .append(",")
                    .append(fruitBalance.getValue().toString());
        }
        return stringBuilder.toString();
    }
}
