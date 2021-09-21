package Service.Activities;
import db.Storage;

public class Supply implements Activities {
    @Override
    public void setBalance(String productName, Integer productBalance) {
        if(Storage.storage.containsKey(productName)) {
            Integer newBalance = productBalance + Storage.storage.get(productName);
            Storage.storage.replace(productName,newBalance);
        }else {
            Storage.storage.put(productName, productBalance);
        }


    }
}
