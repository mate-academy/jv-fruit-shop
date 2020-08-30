package core.basesyntax;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Storage {
    private static Map<String, TreeMap<LocalDate, Integer>> fruitsInStore = new HashMap<>();

    public static TreeMap<LocalDate, Integer> getFruit(String fruit) {
        return new TreeMap<>(fruitsInStore.get(fruit));
    }

    public static void setTransaction(Transaction newTransaction) {
        String fruitType = newTransaction.getName();
        int fruitAmount = newTransaction.getQuantity();
        String operationType = newTransaction.getOperationType();
        LocalDate date = newTransaction.getDate();

        fruitsInStore.putIfAbsent(fruitType, new TreeMap<>());
        Storage.fruitsInStore.get(fruitType).computeIfPresent(date, (key, value)
                -> StoreOperations.calculate(value, fruitAmount, operationType));
        Storage.fruitsInStore.get(fruitType).putIfAbsent(date, fruitAmount);
    }

    public static int getExpirationDateReminder(String fruit, LocalDate date) {
        return fruitsInStore.get(fruit).get(date);
    }

    public static void removeExpirationDateFruitReminder(String fruitType, LocalDate date) {
        fruitsInStore.get(fruitType).remove(date);
    }

    public static void clearStorage() {
        fruitsInStore.clear();
    }

    public static Map<String, TreeMap<LocalDate, Integer>> getAllFruits() {
        return new HashMap<>(fruitsInStore);
    }

    public static boolean isFruitAbsent(String fruitType) {
        return !fruitsInStore.containsKey(fruitType);
    }
}
