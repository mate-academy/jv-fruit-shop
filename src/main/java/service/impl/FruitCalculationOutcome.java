package service.impl;

import static db.StorageTotalBalance.fruitStorageTotalBalance;

import model.FruitTransaction;
import service.FruitCalculation;

public class FruitCalculationOutcome implements FruitCalculation {
    public void fruitStorageCalculation(FruitTransaction fruit) {
        int quantity = (fruitStorageTotalBalance.containsKey(fruit.getFruit()))
                ? fruitStorageTotalBalance.get(fruit.getFruit()) - fruit.getQuantity() :
                fruit.getQuantity();
        fruitStorageTotalBalance.put(fruit.getFruit(), quantity);
    }
}
