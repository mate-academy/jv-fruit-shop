package Service.Activities;

import db.Storage;

import javax.management.openmbean.InvalidKeyException;

public class Purchase implements Activities {
    @Override
    public void setBalance(String productName, Integer productBalance) {
        Integer currentBalance;
        if(Storage.storage.containsKey(productName)) {
            currentBalance = Storage.storage.get(productName);
        } else {
            throw new InvalidKeyException("Invalid key, " + productName);
        }
        if(currentBalance > productBalance) {
            Integer newCurrentBalance =currentBalance - productBalance;
            Storage.storage.replace(productName, newCurrentBalance);
        }else {
            throw new RuntimeException("Operation Purchase cannot be performed with this data: " + productBalance);
        }


    }
}
