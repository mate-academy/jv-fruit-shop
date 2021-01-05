package fshop.service.workfile;

import fshop.db.FoodDao;
import fshop.model.Food;
import java.util.Map;

public interface WriteCsv {
    Map<Food, Integer> write();

    void setFoodDao(FoodDao foodDao);
}
