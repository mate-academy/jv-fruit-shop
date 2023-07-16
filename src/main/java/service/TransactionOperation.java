package service;

import db.FruitStorage;
import java.util.ArrayList;
import model.InputDataType;

public class TransactionOperation {
    public void transactionOperation(ArrayList<InputDataType> operations, FruitStorage storage) {
        for (InputDataType operation : operations) {
            switch (operation.getOperation()) {
                case "b":
                    storage.setFruit(operation.getFruit(), operation.getQuantity());
                    break;
                case "s":
                case "r":
                    storage.addFruitsToStock(operation.getFruit(), operation.getQuantity());
                    break;
                case "p":
                    storage.removeFruitsFromStock(operation.getFruit(), operation.getQuantity());
                    break;
                default:
                    break;
            }
        }
    }
}
