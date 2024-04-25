package core.basesyntax.service.strategy;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.dao.FruitDaoImpl;

public class ROperationServiceImpl implements OperationService {
    private static final int TWO = 2;
    private static final String SEPARATOR = ",";

    private FruitDao fruitDao = new FruitDaoImpl();

    @Override
    public int doOperation(String line) {
        String[] lineSplit = line.split(SEPARATOR);
        return fruitDao.getFruit(line).getAmount() + Integer.parseInt(lineSplit[TWO]);
    }
}
