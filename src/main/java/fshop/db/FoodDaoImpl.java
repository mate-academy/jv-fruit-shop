package fshop.db;

import fshop.model.Food;
import fshop.service.FoodService;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class FoodDaoImpl implements FoodDao {
    private static final String BALANCE = "b";
    private static final String COMA = ",";
    private Map<Food, Integer> dataOfBalance;
    private FoodService foodService;

    public FoodDaoImpl() {
        dataOfBalance = new HashMap<>();
        foodService = new FoodService();
    }

    @Override
    public void addAll(List<String> fileLines) {
        Iterator<String> listAfterRead = fileLines.iterator();
        while (listAfterRead.hasNext()) {
            String line = listAfterRead.next();
            if (line.substring(0, line.indexOf(COMA)).equals(BALANCE)) {
                String nameOfFood = line.substring(line.indexOf(COMA) + 1, line.lastIndexOf(COMA));
                Integer numberOfFood = Integer.valueOf(line.substring(line.lastIndexOf(COMA) + 1));
                dataOfBalance.put(new Food(nameOfFood, numberOfFood), numberOfFood);
            }
        }
    }

    @Override
    public Integer get(Food food) {
        Objects.requireNonNull(food);
        return dataOfBalance.get(food);
    }

    public void updateAll(List<String> fileLines) {
        fileLines.remove(0);

        for (Map.Entry<Food, Integer> entry : dataOfBalance.entrySet()) {
            Iterator<String> listIterator = fileLines.iterator();
            int currentValue = entry.getValue();
            while (listIterator.hasNext()) {
                String key = listIterator.next();
                String subKey = key.substring(key.indexOf(COMA) + 1, key.lastIndexOf(COMA));
                if (subKey.equals(entry.getKey().getName())) {
                    currentValue = foodService.selectStrategy(key, currentValue) < 0
                            ? currentValue : foodService.selectStrategy(key, currentValue);
                }
            }
            dataOfBalance.put(entry.getKey(), currentValue);
        }

    }

    public Map<Food, Integer> getDataOfBalance() {
        return dataOfBalance;
    }
}
