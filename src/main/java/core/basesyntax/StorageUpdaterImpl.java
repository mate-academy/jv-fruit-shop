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
        if (newTransaction.getOperationType().equals("b")) {
            updateStorageAfterPurchase(newTransaction);
            return;
        }
        Storage.setTransaction(newTransaction);
    }

    private void updateStorageAfterPurchase(Transaction newTransaction) {
        String fruitType = newTransaction.getName();
        int fruitAmount = newTransaction.getQuantity();
        LocalDate date = newTransaction.getDate();

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
                newTransaction.setQuantity(neededToSell);
                newTransaction.setDate(toCompare);
                Storage.setTransaction(newTransaction);
                return;
            } else {
                neededToSell = neededToSell - expirationDateReminder;
                Storage.removeExpirationDateFruitReminder(fruitType, toCompare);
            }
        }
    }
}
