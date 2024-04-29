package core.basesyntax.strategy;

import core.basesyntax.dao.FruitDao;

public class BalanceStrategyHandlerImpl implements StrategyHandler {
    private static final int FRUIT_AMOUNT_POSITION_IN_ARR = 2;
    private static final String SEPARATOR = ",";
    private final FruitDao fruitDao;

    public BalanceStrategyHandlerImpl(FruitDao fruitDao) {
        this.fruitDao = fruitDao;
    }

    @Override
    public int doStrategy(String line) {
        String[] lineSplit = line.split(SEPARATOR);
        return fruitDao.getFruit(lineSplit[FRUIT_AMOUNT_POSITION_IN_ARR]).getAmount()
                + Integer.parseInt(lineSplit[FRUIT_AMOUNT_POSITION_IN_ARR]);
    }
}
