package core.basesyntax.service;

import core.basesyntax.model.FruitBox;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Storage {
    private Map<String, FruitBox> fruitStorage = new LinkedHashMap<>();

    public int getAmount(String fruitType) {
        return fruitStorage.values().stream()
                .filter(fruit -> fruit.getFruitType().equals(fruitType))
                .map(FruitBox::getQuantity)
                .reduce(0, Integer::sum);
    }
    
    public String getAllInfo() {
        StringBuilder builder = new StringBuilder();
        for (Map.Entry<String, FruitBox> pair: fruitStorage.entrySet()) {
            builder.append(pair.getKey())
                    .append(",")
                    .append(pair.getValue().getQuantity())
                    .append("\n");
        }
        return builder.toString();
    }

    public void addFruits(List<Operation> operations) {
        for (Operation operation : operations) {
            fruitStorage = operation.changeQuantity(getAmount(operation.fruit.getFruitType()),
                    fruitStorage);
        }
    }
}
