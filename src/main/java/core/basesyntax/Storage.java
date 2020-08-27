package core.basesyntax;

import core.basesyntax.model.Transaction;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class Storage {

    Map<String, Map<LocalDate,Integer>> fruitStorage;

    public Storage() {
        fruitStorage = new HashMap<>();
    }

    public Map<String, Map<LocalDate, Integer>> getFruitStorage() {
        return fruitStorage;
    }

    public void addToStore(Transaction transaction) {
        Map<LocalDate, Integer> box;
        LocalDate expirationDate = LocalDate.parse(transaction.getDate());
        Integer quantity = Integer.parseInt(transaction.getQuantity());

        if (fruitStorage.isEmpty() || (box = fruitStorage.get(transaction.getFruit())) == null) {
            fruitStorage.put(transaction.getFruit(),
                    Map.of(expirationDate, quantity));
            return;
        }
        Map<LocalDate, Integer> newBox = new HashMap<>(box);
        if (box.containsKey(expirationDate)) {
            newBox.put(expirationDate, box.get(expirationDate) + quantity);
        } else {
            newBox.put(expirationDate, quantity);
        }
        fruitStorage.put(transaction.getFruit(), newBox);
    }

    public void removeFromStore(Transaction transaction) {
        Map<LocalDate, Integer> box;
        int currentQuantity = 0;
        LocalDate expirationDate = LocalDate.parse(transaction.getDate());
        Integer quantity = Integer.parseInt(transaction.getQuantity());

        if (fruitStorage.isEmpty() || (box = fruitStorage.get(transaction.getFruit())) == null) {
            throw new RuntimeException("Not enough fruits!");
        }
        Map<LocalDate, Integer> removedBox = new HashMap<>(box);
        Set<LocalDate> localDates = new TreeSet<>(removedBox.keySet());
        for (LocalDate date : localDates) {
            if (expirationDate.isBefore(date)) {
                if ((currentQuantity += box.get(date)) >= quantity) {
                    removedBox.put(date, currentQuantity - quantity);
                    fruitStorage.put(transaction.getFruit(), removedBox);
                    break;
                }
            }
            removedBox.remove(date);
        }
        fruitStorage.put(transaction.getFruit(), removedBox);
        if (removedBox.isEmpty()) {
            throw new RuntimeException("There is no fresh fruits anymore!");
        }
    }

    public List<String> reportPrinter() {
        List<String> report = new ArrayList<>();
        report.add("fruit,quantity");
        for (Map.Entry<String, Map<LocalDate, Integer>> entry : fruitStorage.entrySet()) {
            Integer reduce = entry.getValue().values().stream().reduce(0, Integer::sum);
            report.add(String.format("%s,%d", entry.getKey(), reduce));
        }
        return report;
    }
}
