package service;

import java.util.Map;
import models.Fruit;

public class ProcessFruitsMapToString implements Process<Map<Fruit,Integer>, String> {
    @Override
    public String process(Map<Fruit, Integer> map) {
        StringBuilder builder = new StringBuilder();
        for (Map.Entry<Fruit, Integer> entry : map.entrySet()) {
            builder.append(entry.getKey().getName())
                    .append(",")
                    .append(entry.getValue())
                    .append(System.lineSeparator());
        }
        String result = builder.toString();
        return result.substring(0, result.length() - 1);
    }
}
