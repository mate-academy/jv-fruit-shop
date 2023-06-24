package solid.service.impl;

import solid.service.ReportGenerator;
import solid.strorage.FruitStorage;

public class ReportGeneratorImpl implements ReportGenerator {
    @Override
    public String generate() {
        StringBuilder resultDataString = new StringBuilder();
        FruitStorage.fruits.forEach((k, v) -> resultDataString.append(k)
                .append(",")
                .append(v)
                .append(System.lineSeparator()));
        return resultDataString.toString();
    }
}
