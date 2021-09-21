package Service.Activities;

import db.Storage;

public class Return implements Activities {
    @Override
    public void setBalance(String productName, Integer productBalance) {
        if(Storage.storage.containsKey(productName)) {
            Integer newBalance = Storage.storage.get(productName) + productBalance;
            Storage.storage.replace(productName, newBalance);
        }else {
            throw new RuntimeException("Can't return the product because this product has never sold, " + productName);
        }

    }
}
