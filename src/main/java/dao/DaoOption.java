package dao;

import java.util.Map;
import java.util.Optional;
import model.Fruit;

public interface DaoOption {

    void add(Fruit fruit, int quality);

    void addAll(Map<Fruit,Integer> fruits);

    Optional<Integer> getFruit(Fruit fruit);
}
