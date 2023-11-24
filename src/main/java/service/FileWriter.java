package service;

import model.FruitStorage;

public interface FileWriter {
    void write(FruitStorage fruitInventory, String reportFileName);
}
