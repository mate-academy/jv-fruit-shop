package service;

import dao.FruitDao;
import service.interfaces.FruitOperationService;

public class FruitSupplyServiceImpl implements FruitOperationService {
    private FruitDao fruitDao;

    public FruitSupplyServiceImpl(FruitDao fruitDao) {
        this.fruitDao = fruitDao;
    }

    @Override
    public void apply(FruitRecordParserImpl fruitRecordParser) {
        int currentQuantity = fruitDao.get(fruitRecordParser.getFruitType());
        fruitDao.put(fruitRecordParser.getFruitType(),
                currentQuantity + fruitRecordParser.getQuantity());
    }
}
