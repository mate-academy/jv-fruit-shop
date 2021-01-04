package core.basesyntax.parse;

import core.basesyntax.model.Fruit;
import java.util.Map;

public class FruitRetortImpl implements FruitReport {

    @Override
    public String create(Map<Fruit, Integer> fruitIntegerMap) {
        StringBuilder report = new StringBuilder();
        report.append("fruit,quantity").append(System.lineSeparator());
        for (Map.Entry<Fruit, Integer> entry : fruitIntegerMap.entrySet()) {
            report.append(entry.getKey().getName()).append(",")
                    .append(entry.getValue()).append(System.lineSeparator());
        }
        return report.toString();
    }
}
