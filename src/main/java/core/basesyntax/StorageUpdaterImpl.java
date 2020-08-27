package core.basesyntax;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class StorageUpdaterImpl implements StorageUpdater {

    public void parseData(List<List<String>> newData) {
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
        Storage.setFruit(fruitType, date, fruitAmount, operationType);
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
