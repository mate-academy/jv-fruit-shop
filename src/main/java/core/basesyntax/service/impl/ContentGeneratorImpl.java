package core.basesyntax.service.impl;

import core.basesyntax.model.Fruit;
import core.basesyntax.service.ContentGenerator;
import java.util.Map;

public class ContentGeneratorImpl implements ContentGenerator {
    private static final String TOP_LINE = "fruit,quantity";
    private static final String SEPARATOR = ",";
    private static final String END_LINE = System.lineSeparator();

    @Override
    public String generateContent(Map<Fruit, Integer> map) {
        StringBuilder contentBuilder = new StringBuilder();
        contentBuilder.append(TOP_LINE)
                .append(END_LINE);
        for (Map.Entry<Fruit, Integer> entry : map.entrySet()) {
            contentBuilder.append(entry.getKey().getName())
                    .append(SEPARATOR)
                    .append(entry.getValue())
                    .append(END_LINE);
        }
        return contentBuilder.toString();
    }
}
