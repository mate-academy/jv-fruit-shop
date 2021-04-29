package service;

import dao.FruitDao;
import model.Fruit;
import service.interfaces.FruitOperationService;

public class FruitReturnServiceImpl implements FruitOperationService {
    private FruitDao fruitDao;

    public FruitReturnServiceImpl(FruitDao fruitDao) {
        this.fruitDao = fruitDao;
    }

    @Override
    public void apply(FruitRecordParserImpl fruitRecordParser) {
        Fruit fruit = new Fruit(fruitRecordParser.getFruitType());
        int currentQuantity = fruitDao.get(fruit);
        currentQuantity = currentQuantity + fruitRecordParser.getQuantity();
        fruitDao.put(fruit, currentQuantity);
    }
}
