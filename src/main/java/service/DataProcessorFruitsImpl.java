package service;

import java.util.Map;
import models.Fruit;

public class DataProcessorFruitsImpl implements DataProcessor<Map<Fruit,Integer>, String> {
    @Override
    public String process(Map<Fruit, Integer> map) {
        StringBuilder builder = new StringBuilder();
        for (Map.Entry<Fruit, Integer> entry : map.entrySet()) {
            builder.append(entry.getKey().getName())
                    .append(",")
                    .append(entry.getValue())
                    .append(System.lineSeparator());
        }
        return String.join(System.lineSeparator(), builder.toString());
    }
}
