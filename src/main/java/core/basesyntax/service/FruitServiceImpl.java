package core.basesyntax.service;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.model.FruitOperation;

import java.util.Map;

public class FruitServiceImpl implements FruitService {
    private FruitDao fruitDao;

    public FruitServiceImpl(FruitDao fruitDao) {
        this.fruitDao = fruitDao;
    }


    @Override
    public void createReport() {

    }
}
