package dao;

public interface WareHouseDao {
    int getStoredQuantity(String fruitName);

    void addFruitLot(String fruitName, Integer quantity);

    void removeFruitLot(String fruitName);
}
