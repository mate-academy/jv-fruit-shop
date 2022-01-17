package core.basesyntax.service.impl;

import core.basesyntax.model.Fruit;
import core.basesyntax.service.FruitsConsumer;
import java.util.List;
import java.util.stream.Collectors;

public class FruitsConsumerCsv implements FruitsConsumer {
    private static final String CSV_HEADER = "fruit,quantity";
    private final String filePath;

    public FruitsConsumerCsv(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public void accept(List<Fruit> fruits) {
        FileUtils.writeFile(fruitsToCsvRows(fruits), filePath);
    }

    private List<String> fruitsToCsvRows(List<Fruit> fruits) {
        List<String> csvRows = fruits.stream()
                .map(fruit -> fruit.getName() + FileUtils.COMMA_SEPARATOR + fruit.getAmount())
                .collect(Collectors.toList());
        csvRows.add(0, CSV_HEADER);
        return csvRows;
    }
}
