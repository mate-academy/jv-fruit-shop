package myfirstproject.service.impl;

import java.util.Map;
import myfirstproject.model.Fruit;
import myfirstproject.service.PreparingData;

public class PrepareDataImpl implements PreparingData {
    private static final String TITLE = "fruit,quantity" + System.lineSeparator();
    private static final String COMMA = ",";

    @Override
    public String prepare(StringBuilder data, Map<Fruit, Integer> mapToWrite) {
        data.append(TITLE);
        for (Map.Entry<Fruit, Integer> map : mapToWrite.entrySet()) {
            data.append(map.getKey().getName())
                    .append(COMMA)
                    .append(map.getValue())
                    .append(System.lineSeparator());
        }
        return data.toString();
    }
}
