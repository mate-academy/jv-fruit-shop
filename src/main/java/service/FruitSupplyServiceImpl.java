package service;

import dao.FruitDao;
import model.Fruit;
import service.interfaces.FruitOperationService;

public class FruitSupplyServiceImpl implements FruitOperationService {
    private FruitDao fruitDao;

    public FruitSupplyServiceImpl(FruitDao fruitDao) {
        this.fruitDao = fruitDao;
    }

    @Override
    public void apply(FruitRecordParserImpl fruitRecordParser) {
        Fruit fruit = new Fruit(fruitRecordParser.getFruitType());
        int currentQuantity = fruitDao.get(fruit);
        fruitDao.put(fruit, currentQuantity + fruitRecordParser.getQuantity());
    }
}
