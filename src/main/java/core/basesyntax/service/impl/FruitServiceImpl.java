package core.basesyntax.service.impl;

import core.basesyntax.dao.FruitBoxDao;
import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitBox;
import core.basesyntax.service.FruitService;
import core.basesyntax.strategy.ActivityStrategy;
import core.basesyntax.strategy.activity.ActivityHandler;
import core.basesyntax.validator.Validator;
import java.util.List;

public class FruitServiceImpl implements FruitService {
    private static final int INDEX_OF_ACTIVITY_TYPE = 0;
    private static final int INDEX_OF_FRUIT_TYPE = 1;
    private static final int INDEX_OF_QUANTITY = 2;
    private final Validator validator;
    private final ActivityStrategy strategy;
    private final FruitBoxDao fruitBoxDao;

    public FruitServiceImpl(Validator validator,
                            ActivityStrategy strategy, FruitBoxDao fruitBoxDao) {
        this.validator = validator;
        this.strategy = strategy;
        this.fruitBoxDao = fruitBoxDao;
    }

    public FruitBox createFruitBox(String fruitType, int value) {
        FruitBox fruitBox = new FruitBox();
        fruitBox.setFruitType(fruitType);
        fruitBox.setQuantity(value);
        Storage.storage.add(fruitBox);
        return fruitBox;
    }

    @Override
    public void updatingFruitBox(List<String> data) {
        validator.validateData(data);
        FruitBox fruitBox;
        for (String line : data) {
            String[] split = line.split(",");
            String activity = split[INDEX_OF_ACTIVITY_TYPE];
            String fruitType = split[INDEX_OF_FRUIT_TYPE];
            int quantity = Integer.parseInt(split[INDEX_OF_QUANTITY]);
            if (activity.equals(ActivityHandler.BALANCE)) {
                int balanceValue = strategy.get(activity).get(quantity);
                createFruitBox(fruitType, balanceValue);
            } else {
                fruitBox = fruitBoxDao.get(fruitType);
                int newValue = fruitBox.getQuantity() + strategy.get(activity).get(quantity);
                fruitBox.setQuantity(newValue);
            }
        }
    }
}
