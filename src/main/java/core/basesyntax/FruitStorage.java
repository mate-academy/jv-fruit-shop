package core.basesyntax;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FruitStorage {
    public Map<String, Integer> fruitStorage(List<Operation> operations) {
        Map<String, Integer> fruitStorage = new HashMap<>();
        Map<String, LocalDate> expiration = new HashMap<>();
        for (Operation operation : operations) {
            if (operation.getType().equals("s") || operation.getType().equals("r")) {
                fruitStorage.merge(operation.getFruit(), operation.getQuantity(), Integer::sum);
                expiration.put(operation.getFruit(), operation.getExpDate());
            }
            if (operation.getType().equals("b")) {
                if (!fruitStorage.containsKey(operation.getFruit())) {
                    throw new RuntimeException("No such fruits in storage, check input file");
                }
                if (fruitStorage.get(operation.getFruit()) < operation.getQuantity()) {
                    throw new RuntimeException("Not enough fruits to sell");
                }
                if (expiration.get(operation.getFruit()).isBefore(operation.getExpDate())) {
                    throw new RuntimeException("You sold expired fruits, check input file");
                }
                operation.setQuantity(- operation.getQuantity());
                fruitStorage.merge(operation.getFruit(), operation.getQuantity(), Integer::sum);
            }
        }
        return fruitStorage;
    }

}
