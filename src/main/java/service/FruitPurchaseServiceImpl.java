package service;

import dao.FruitDao;
import exception.InsufficientAmountException;
import service.interfaces.FruitOperationService;

public class FruitPurchaseServiceImpl implements FruitOperationService {
    private static final String MESSAGE_FOR_EXCEPTION = "Insufficient quantity of goods";
    private FruitDao fruitDao;

    public FruitPurchaseServiceImpl(FruitDao fruitDao) {
        this.fruitDao = fruitDao;
    }

    @Override
    public void apply(FruitRecordParserImpl fruitRecordParser) {
        int currentQuantity = fruitDao.get(fruitRecordParser.getFruitType());
        currentQuantity = currentQuantity - fruitRecordParser.getQuantity();
        if (currentQuantity < 0) {
            throw new InsufficientAmountException(MESSAGE_FOR_EXCEPTION);
        }
        fruitDao.put(fruitRecordParser.getFruitType(), currentQuantity);
    }
}
