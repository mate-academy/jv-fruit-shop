package Service.Activities;

import db.Storage;

public class Balance implements Activities {

    @Override
    public void setBalance(String productName, Integer productBalance) {
        if(Storage.storage.containsKey(productName)) {
            Storage.storage.replace(productName, productBalance);
        }else {
            Storage.storage.put(productName, productBalance);
        }
    }
}
