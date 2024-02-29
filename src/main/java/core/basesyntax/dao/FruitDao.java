package core.basesyntax.dao;

public interface FruitDao {
    Integer add(String fruitName, int amount);

    String createReport();
}
