package core.basesyntax.dao;

import core.basesyntax.model.Fruit;

import java.util.List;

public interface FruitsDao {
    List<String> readFromFile();
    void writeToFile();
    void add(Fruit fruit);
    Fruit get(String someFruit);
}