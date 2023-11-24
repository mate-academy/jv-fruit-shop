package service;

import db.FruitStorage;

public interface FileWriter {
    void write(FruitStorage fruitInventory, String reportFileName);
}
