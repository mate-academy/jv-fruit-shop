package core.basesyntax;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
import java.util.TreeMap;

public class UpdateStorageImpl implements UpdateStorage {

    public void parseFileToStorage(String fileName) throws IOException {
        List<List<String>> newData = new ReadFromFile().getNewData(fileName);
        for (List<String> raw : newData) {
            putLineToStorage(raw);
        }
    }

    public void putLineToStorage(List<String> raw) {
        String operationType = raw.get(0);
        String fruitType = raw.get(1);
        int fruitAmount = Integer.parseInt(raw.get(2));
        LocalDate date = LocalDate.parse(raw.get(3));
        if (operationType.equals("b") && !Storage.fruitsInStore.containsKey(fruitType)) {
            return;
        }
        if (operationType.equals("b")) {
            TreeMap<LocalDate, Integer> fruitReminders = new TreeMap<>(Storage
                                                        .fruitsInStore.get(fruitType));
            int neededToSell = fruitAmount;
            for (LocalDate toCompare : fruitReminders.keySet()) {
                int expirationDateReminder = Storage.fruitsInStore.get(fruitType).get(toCompare);
                if (date.isAfter(toCompare)) {
                    continue;
                }
                if (Storage.fruitsInStore.get(fruitType).get(toCompare) > neededToSell) {
                    Storage.fruitsInStore.get(fruitType).put(toCompare, (int) StoreOperations
                            .calculate(expirationDateReminder, neededToSell, operationType));
                    break;
                } else {
                    neededToSell = neededToSell
                                    - Storage.fruitsInStore.get(fruitType).get(toCompare);
                    Storage.fruitsInStore.get(fruitType).remove(toCompare);
                }
            }
            return;
        }
        Storage.fruitsInStore.putIfAbsent(fruitType, new TreeMap<>());
        Storage.fruitsInStore.get(fruitType).computeIfPresent(date, (key, value)
                -> (int) StoreOperations.calculate(value, fruitAmount, operationType));
        Storage.fruitsInStore.get(fruitType).putIfAbsent(date, fruitAmount);
    }
}
