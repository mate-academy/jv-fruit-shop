package handlers;

import db.Storage;
import model.FruitTransaction;

public class PurchaseHandler implements OperationTypeHandler {

    @Override
    public void handler(FruitTransaction fruitTransaction) {
        Integer currentQuantity = Storage.storage.get(fruitTransaction.getFruit());
        if (currentQuantity == null) {
            throw new RuntimeException("Fruit " + fruitTransaction.getFruit() + " not found in storage");
        }
        if (currentQuantity < fruitTransaction.getQuantity()) {
            throw new RuntimeException("Can't purchase " + fruitTransaction.getQuantity() + " " + fruitTransaction.getFruit()
                    + "! Only " + currentQuantity + " on the balance");
        } else {
            Storage.storage.put(fruitTransaction.getFruit(), currentQuantity - fruitTransaction.getQuantity());
        }
    }
}

















    /*
    public void handler(FruitTransaction fruitTransaction) {
        //String fruitTransaction.getFruit() = fruitTransaction.getFruit();


        //int fruitTransaction.getQuantity() = fruitTransaction.getQuantity();
        if (Storage.storage.get(fruitTransaction.getFruit()) < fruitTransaction.getQuantity()) {
            throw new RuntimeException("Can`t purchase  on the balance");
        }
        Storage.storage.put(fruitTransaction.getFruit(), Storage.storage.get(fruitTransaction.getFruit())
                - fruitTransaction.getQuantity());


     */
        /*
        if (Storage.storage.get(key) - value >= 0) {
            Storage.storage.put(key, Storage.storage.get(key) - value);
        } else {
            throw new RuntimeException("Can`t purchase " + value + " " + key
                    + "! Only " + Storage.storage.get(key) + " on the balance");
        }*/



