package service;

import dao.FruitDao;
import service.interfaces.FruitOperationService;

public class FruitReturnServiceImpl implements FruitOperationService {
    private FruitDao fruitDao;

    public FruitReturnServiceImpl(FruitDao fruitDao) {
        this.fruitDao = fruitDao;
    }

    @Override
    public void apply(FruitRecordParserImpl fruitRecordParser) {
        int currentQuantity = fruitDao.get(fruitRecordParser.getFruitType());
        currentQuantity = currentQuantity + fruitRecordParser.getQuantity();
        fruitDao.put(fruitRecordParser.getFruitType(), currentQuantity);
    }
}
