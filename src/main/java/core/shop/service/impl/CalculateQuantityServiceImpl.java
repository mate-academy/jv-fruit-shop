package core.shop.service.impl;

import core.shop.model.ActivityType;
import core.shop.model.FruitRecord;
import core.shop.service.CalculateQuantityService;
import java.util.List;

public class CalculateQuantityServiceImpl implements CalculateQuantityService {
    @Override
    public int calculateQuantity(List<FruitRecord> fruits, String fruitName) {
        return fruits.stream()
                .filter(fruit -> fruit.getFruitName().equals(fruitName))
                .mapToInt(fruit -> {
                    if (fruit.getActivityType().equals(ActivityType.BALANCE)
                            || fruit.getActivityType().equals(ActivityType.SUPPLY)
                            || fruit.getActivityType().equals(ActivityType.RETURN)) {
                        return fruit.getQuantity();
                    } else if (fruit.getActivityType().equals(ActivityType.PURCHASE)) {
                        return -fruit.getQuantity();
                    } else {
                        return 0;
                    }
                })
                .sum();
    }
}
