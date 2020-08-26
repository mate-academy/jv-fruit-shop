package core.basesyntax;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class StorageUpdaterImpl implements StorageUpdater {

    public void parseData(String fileName) throws IOException {
        List<List<String>> newData = new LocalFileReader().readFromFile(fileName);
        // принимать метод
        for (List<String> raw : newData) {
            putLineToStorage(raw);
        }
    }

    public void putLineToStorage(List<String> raw) {
        String operationType = raw.get(0);
        String fruitType = raw.get(1);
        int fruitAmount = Integer.parseInt(raw.get(2));
        LocalDate date = LocalDate.parse(raw.get(3));
        if (operationType.equals("b")) {
            updateStorageAfterPurchase(fruitType, date, fruitAmount, operationType);
            return;
        }

        /*if (operationType.equals("b") && Storage.fruitIsAbsent(fruitType)) {
            return;
        }
        if (operationType.equals("b")) {
            Map<LocalDate, Integer> fruitReminders = new TreeMap<>(Storage.getFruit(fruitType));
            int neededToSell = fruitAmount;
            for (LocalDate toCompare : fruitReminders.keySet()) {
                int expirationDateReminder = Storage.getExpirationDateReminder(fruitType, toCompare);
                if (date.isAfter(toCompare)) {
                    continue;
                }
                if (expirationDateReminder > neededToSell) {
                    // Storage.fruitsInStore.get(fruitType).put(toCompare, StoreOperations
                    //       .calculate(expirationDateReminder, neededToSell, operationType));
                    Storage.setFruit(fruitType, toCompare, neededToSell, operationType);
                    //int finalNeededToSell = neededToSell;
                    //Storage.fruitsInStore.get(fruitType).computeIfPresent(toCompare, (key, value)
                            //-> StoreOperations.calculate(value, finalNeededToSell, operationType));
                    break;
                } else {
                    neededToSell = neededToSell - expirationDateReminder;
                    Storage.removeExpirationDateFruitReminder(fruitType, toCompare);
                }
            }
            return;
        }*/
        Storage.setFruit(fruitType, date, fruitAmount, operationType);
        /*Storage.fruitsInStore.putIfAbsent(fruitType, new TreeMap<>());
        Storage.fruitsInStore.get(fruitType).computeIfPresent(date, (key, value)
                -> StoreOperations.calculate(value, fruitAmount, operationType));
        Storage.fruitsInStore.get(fruitType).putIfAbsent(date, fruitAmount);*/
    }

    private void updateStorageAfterPurchase(String fruitType, LocalDate date,
                                 int fruitAmount, String operationType) {
        if (Storage.fruitIsAbsent(fruitType)) {
            return;
        }
        Map<LocalDate, Integer> fruitReminders = new TreeMap<>(Storage.getFruit(fruitType));
        int neededToSell = fruitAmount;
        for (LocalDate toCompare : fruitReminders.keySet()) {
            int expirationDateReminder = Storage.getExpirationDateReminder(fruitType, toCompare);
            if (date.isAfter(toCompare)) {
                continue;
            }
            if (expirationDateReminder > neededToSell) {
                Storage.setFruit(fruitType, toCompare, neededToSell, operationType);
                return;
            } else {
                neededToSell = neededToSell - expirationDateReminder;
                Storage.removeExpirationDateFruitReminder(fruitType, toCompare);
            }
        }
    }
}
