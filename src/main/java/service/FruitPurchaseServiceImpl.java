package service;

import dao.FruitDao;
import exception.InsufficientAmountException;
import model.Fruit;
import service.interfaces.FruitOperationService;

public class FruitPurchaseServiceImpl implements FruitOperationService {
    private static final String MESSAGE_FOR_EXCEPTION = "Insufficient quantity of goods";
    private FruitDao fruitDao;

    public FruitPurchaseServiceImpl(FruitDao fruitDao) {
        this.fruitDao = fruitDao;
    }

    @Override
    public void apply(FruitRecordParserImpl fruitRecordParser) {
        Fruit fruit = new Fruit(fruitRecordParser.getFruitType());
        int currentQuantity = fruitDao.get(fruit);
        currentQuantity = currentQuantity - fruitRecordParser.getQuantity();
        if (currentQuantity < 0) {
            throw new InsufficientAmountException(MESSAGE_FOR_EXCEPTION);
        }
        fruitDao.put(fruit, currentQuantity);
    }
}
