package core.basesyntax.service.impl;

import core.basesyntax.model.Fruit;
import core.basesyntax.service.FruitsConsumer;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class FruitsConsumerCsv implements FruitsConsumer {
    private static final String CSV_HEADER = "fruit,quantity";
    private final String filePath;

    public FruitsConsumerCsv(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public void accept(Map<Fruit, Integer> fruitMap) {
        FileUtils.writeFile(getCsvRowsFromFruits(fruitMap), filePath);
    }

    private List<String> getCsvRowsFromFruits(Map<Fruit, Integer> fruitMap) {
        List<String> csvRows = fruitMap.entrySet().stream()
                .map(e -> e.getKey().toString() + FileUtils.COMMA_SEPARATOR + e.getValue())
                .collect(Collectors.toList());
        csvRows.add(0, CSV_HEADER);
        return csvRows;
    }
}
