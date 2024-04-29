package core.basesyntax.strategy;

import core.basesyntax.dao.FruitDao;

public class SupplyStrategyHandlerImpl implements StrategyHandler {
    private static final int FRUIT_AMOUNT_POSITION_IN_ARR = 2;
    private static final String SEPARATOR = ",";
    private final FruitDao fruitDao;

    public SupplyStrategyHandlerImpl(FruitDao fruitDao) {
        this.fruitDao = fruitDao;
    }

    @Override
    public int doStrategy(String line) {
        String[] lineSplit = line.split(SEPARATOR);
        return fruitDao.getFruit(line).getAmount()
                + Integer.parseInt(lineSplit[FRUIT_AMOUNT_POSITION_IN_ARR]);
    }
}
