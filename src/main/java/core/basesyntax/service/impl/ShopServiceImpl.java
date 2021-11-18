package core.basesyntax.service.impl;

import core.basesyntax.model.Fruit;
import core.basesyntax.service.ShopService;
import core.basesyntax.service.activity.TypeActivity;
import core.basesyntax.strategy.ActivityStrategy;
import core.basesyntax.validator.Validator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class ShopServiceImpl implements ShopService {
    private static final int INDEX_OF_ACTIVITY_TYPE = 0;
    private static final int INDEX_OF_FRUIT_TYPE = 1;
    private static final int INDEX_OF_QUANTITY = 2;
    private ActivityStrategy activityStrategy;
    private Validator validator;

    public ShopServiceImpl(ActivityStrategy activityStrategy, Validator validator) {
        this.activityStrategy = activityStrategy;
        this.validator = validator;
    }

    @Override
    public void updatingFruitStorage(List<String> data) {
        validator.validateData(data);
        for (String line : data) {
            String[] split = line.split(",");
            TypeActivity operationType = TypeActivity.valueOf(split[INDEX_OF_ACTIVITY_TYPE]);
            String fruitName = split[INDEX_OF_FRUIT_TYPE];
            int value = Integer.parseInt(split[INDEX_OF_QUANTITY]);
            activityStrategy.get(operationType).apply(fruitName, value);
        }
    }

    @Override
    public Map<String, Long> amountCalculator(List<Fruit> fruits) {
        return fruits.stream()
                .map(Fruit::getName)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
    }

}

