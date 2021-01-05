package fshop.db;

import fshop.model.Food;
import java.util.Map;

public interface FoodDao {
    Integer get(Food food);

    Map<Food, Integer> getDataOfBalance();

    void addAll();

    void updateAll();
}
