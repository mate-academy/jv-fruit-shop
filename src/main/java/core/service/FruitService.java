package core.service;

import java.util.Map;

public interface FruitService {
    void update(String fruitName, int quantity);

    int get(String fruitName);

    Map<String,Integer> getAll();
}
