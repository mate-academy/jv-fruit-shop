package dao;

public interface FruitDao {
    Integer getQuantity(String fruitName);

    void add(String fruitName, Integer amount);
}
