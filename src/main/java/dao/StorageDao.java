package dao;

import service.OperationService;

public interface StorageDao {
    void addNewFruit(String fruit, int quantity);

    void changeQuantityOfFruit(String fruit, int quantity, OperationService operation);
}
