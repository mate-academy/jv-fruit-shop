package core.basesyntax.service;

import core.basesyntax.dao.FruitDao;

import java.util.List;

public class FruitServiceImpl implements FruitService {
    private FruitDao fruitDao;
    private FruitParser fruitParser;
    private DataValidator dataValidator;

    public FruitServiceImpl(FruitDao fruitDao, FruitParser fruitParser, DataValidator dataValidator) {
        this.fruitDao = fruitDao;
        this.fruitParser = fruitParser;
        this.dataValidator = dataValidator;
    }


    @Override
    public void createReport(String source, String destination) {
        List<String> inputData = fruitDao.get();
        dataValidator.validate(inputData);


    }
}
