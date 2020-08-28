package core.basesyntax;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class FruitStorage {
    private Map<String, Transaction> fruitStorage = new LinkedHashMap<>();

    public int getQuantity(String fruitType) {
        int newQuantity = 0;
        for (Transaction fruit : fruitStorage.values()) {
            if (fruit.getFruitType().equals(fruitType)) {
                int quantity = fruit.getQuantity();
                newQuantity = newQuantity + quantity;
            }
        }
        return newQuantity;
    }
    
    public String getInfo() {
        StringBuilder builder = new StringBuilder();
        for (Map.Entry<String, Transaction> pair: fruitStorage.entrySet()) {
            builder.append(pair.getKey())
                    .append(",")
                    .append(pair.getValue().getQuantity())
                    .append("\n");
        }
        return builder.toString();
    }

    public void add(List<FruitOperation> operation) {
        for (FruitOperation fruitOperation : operation) {
            fruitStorage = fruitOperation.execute(getQuantity(
                    fruitOperation.transaction.getFruitType()),
                    fruitStorage);
        }
    }
}
