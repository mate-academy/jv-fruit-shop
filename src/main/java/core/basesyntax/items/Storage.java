package core.basesyntax.items;

import java.time.LocalDate;
import java.util.Map;
import java.util.TreeMap;

public class Storage {
    private final Map<String, Map<LocalDate, Product>> fruitStorage = new TreeMap<>();

    public Map<LocalDate, Product> getBoxWithFruit(String fruit) {
        return fruitStorage.get(fruit);
    }

    public boolean isFruitInStorage(String fruit) {
        return fruitStorage.containsKey(fruit);
    }

    public void addNewFruitToRange(Product product) {
        String fruit = product.getType();
        LocalDate expirationDate = product.getDate();
        fruitStorage.put(fruit, new TreeMap<>());
        fruitStorage.get(fruit).put(expirationDate, product);
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (String fruit : fruitStorage.keySet()) {
            for (LocalDate expirationDate : fruitStorage.get(fruit).keySet()) {
                builder.append(fruit)
                        .append(",")
                        .append(fruitStorage.get(fruit).get(expirationDate).getQuantity())
                        .append(",")
                        .append(expirationDate)
                        .append("\n");
            }
        }
        return builder.length() == 0 ? builder.toString() : builder
                .append("Total amount:").append("\n")
                .append(totalAmountToString())
                .toString();
    }

    private String totalAmountToString() {
        StringBuilder builder = new StringBuilder();
        int count = 0;
        for (String fruit : fruitStorage.keySet()) {
            builder.append(fruit).append(",");
            for (LocalDate expirationDate : fruitStorage.get(fruit).keySet()) {
                count += fruitStorage.get(fruit).get(expirationDate).getQuantity();
            }
            builder.append(count).append("\n");
            count = 0;
        }
        return builder.toString();
    }
}
