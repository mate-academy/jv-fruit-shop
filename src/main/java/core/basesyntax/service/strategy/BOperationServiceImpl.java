package core.basesyntax.service.strategy;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.dao.FruitDaoImpl;

public class BOperationServiceImpl implements OperationService {
    private static final int FRUIT_AMOUNT_POSITION_IN_ARR = 2;
    private static final String SEPARATOR = ",";
    private final FruitDao fruitDao = new FruitDaoImpl();

    @Override
    public int doOperation(String line) {
        String[] lineSplit = line.split(SEPARATOR);
        return fruitDao.getFruit(lineSplit[FRUIT_AMOUNT_POSITION_IN_ARR]).getAmount()
                + Integer.parseInt(lineSplit[FRUIT_AMOUNT_POSITION_IN_ARR]);
    }
}
