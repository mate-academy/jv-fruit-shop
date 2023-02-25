package core.basesyntax.dao;

public interface FruitDao {

    void add(String fruit, Integer amount);

    void takeAway(String fruit, Integer amount);

}
