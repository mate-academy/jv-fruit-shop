package fshop.service.workfile;

import fshop.model.Food;
import java.util.Map;

public interface WriteCsv {
    Map<Food, Integer> write(Map<Food, Integer> mapFromDb);
}
