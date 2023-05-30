package core.basesyntax.service;

import core.basesyntax.db.Storage;
import core.basesyntax.model.Fruit;
import java.util.Map;

public class FruitServiceImpl implements FruitService {

    @Override
    public String getReport() {
        StringBuilder content = new StringBuilder();
        content.append("fruit,quantity");
        for (Map.Entry<Fruit, Integer> entry : Storage.storage.entrySet()) {
            content.append("\n").append(entry.getKey().getName())
                    .append(",").append(entry.getValue());

        }
        return content.toString();
    }
}
