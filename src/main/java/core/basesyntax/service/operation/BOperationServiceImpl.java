package core.basesyntax.service.operation;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.dao.FruitDaoImpl;

public class BOperationServiceImpl implements OperationService {
    private FruitDao fruitDao = new FruitDaoImpl();

    @Override
    public int doOperation(String line) {
        String[] lineSplit = line.split(",");
        return fruitDao.getFruit(lineSplit[2]).getAmount() + Integer.parseInt(lineSplit[2]);
    }
}
