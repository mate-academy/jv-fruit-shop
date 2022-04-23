package dao;

public interface FruitTransactionDao {
    void addToStorage(String fruitName,Integer fruitQuantity);

    Integer getFromStorage(String fruitName);
}
