package core.basesyntax.db;

import java.util.List;

public interface FruitShopDao {
    int getStorageSize();//returns storage size

    List<String> getAllFruitsWithQuantities();// give us all fruits and quantities

    void addFruitAndQuantity(String fruit, int quantity);//adding fruits and quantities

    void addFruitWithoutQuantity(String fruit);// adding fruits without quantities
}
