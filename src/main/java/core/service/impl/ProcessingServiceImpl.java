package core.service.impl;

import core.model.Fruit;
import core.service.ProcessingService;
import core.storage.DataBase;
import core.strategy.FruitStrategy;
import java.util.List;
import java.util.Map;

public class ProcessingServiceImpl implements ProcessingService {
    private static final String CSV_LINE_SPLITERATOR = ",";
    private static final int OPERATION_INDEX = 0;
    private static final int FRUIT_INDEX = 1;
    private static final int QUANTITY_INDEX = 2;

    @Override
    public void process(Map<String, FruitStrategy> strategyMap, List<String> stringList) {
        DataBase dataBase = new DataBase();
        for (String line : stringList) {
            String[] splitLine = line.split(CSV_LINE_SPLITERATOR);
            if (!strategyMap.containsKey(splitLine[OPERATION_INDEX])) {
                continue;
            }
            FruitStrategy fruitStrategy = strategyMap.get(splitLine[OPERATION_INDEX]);
            fruitStrategy.execute(dataBase, new Fruit(splitLine[FRUIT_INDEX]),
                    Integer.valueOf(splitLine[QUANTITY_INDEX]));
        }
    }
}
