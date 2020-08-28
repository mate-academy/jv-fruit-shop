package core.basesyntax;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class StorageUpdaterImpl implements StorageUpdater {

    public void parseDataToStorage(List<Transaction> newData) {
        for (Transaction newTransaction : newData) {
            putLineToStorage(newTransaction);
        }
    }

    public void putLineToStorage(Transaction newTransaction) {
        String operationType = newTransaction.getOperationType();
        String fruitType = newTransaction.getName();
        int fruitAmount = newTransaction.getQuantity();
        LocalDate date = newTransaction.getDate();

        if (operationType.equals("b")) {
            updateStorageAfterPurchase(fruitType, date, fruitAmount, operationType);
            return;
        }
        Storage.setFruit(fruitType, date, fruitAmount, operationType);
    }

    private void updateStorageAfterPurchase(String fruitType, LocalDate date,
                                 int fruitAmount, String operationType) {
        if (Storage.isFruitAbsent(fruitType)) {
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
