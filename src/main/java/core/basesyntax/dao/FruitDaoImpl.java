package core.basesyntax.dao;

import core.basesyntax.db.Storage;
import core.basesyntax.model.Fruit;
import core.basesyntax.service.StrategyService;
import java.util.List;

public class FruitDaoImpl implements FruitDao {
    private static final int FRUIT_STRATEGY_POSITION_IN_ARR = 0;
    private static final int FRUIT_NAME_POSITION_IN_ARR = 1;
    private static final int FRUIT_AMOUNT_POSITION_IN_ARR = 2;
    private static final String SEPARATOR = ",";
    private final StrategyService strategyService;

    public FruitDaoImpl(StrategyService strategyService) {
        this.strategyService = strategyService;
    }

    @Override
    public Fruit getFruit(String line) {
        String[] splitLine = line.split(SEPARATOR);
        String fruitName = splitLine[FRUIT_NAME_POSITION_IN_ARR];
        for (int i = 0; i < Storage.FRUITS.size(); i++) {
            Fruit fruit = Storage.FRUITS.get(i);
            if (fruit.getName().equals(fruitName)) {
                return fruit;
            }
        }
        return null;
    }

    @Override
    public void addFruit(String line) {
        String[] splitLine = line.split(SEPARATOR);
        String fruitName = splitLine[FRUIT_NAME_POSITION_IN_ARR];
        int fruitAmount = Integer.parseInt(splitLine[FRUIT_AMOUNT_POSITION_IN_ARR]);
        Storage.FRUITS.add(new Fruit(fruitName, fruitAmount));
    }

    @Override
    public void updateAmount(String line) {
        String typeStrategy = line.split(SEPARATOR)[FRUIT_STRATEGY_POSITION_IN_ARR];
        getFruit(line).setAmount(strategyService.getStrategy(typeStrategy).doStrategy(line));
    }

    @Override
    public List<Fruit> getFruitList() {
        return Storage.FRUITS;
    }
}
