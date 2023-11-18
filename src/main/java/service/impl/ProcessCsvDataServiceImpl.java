package service.impl;

import db.FruitShopDao;
import java.util.List;
import model.FruitTransaction;
import service.ProcessCsvDataService;

public class ProcessCsvDataServiceImpl implements ProcessCsvDataService {
    private static final String SEPARATOR = ",";
    private static final int OPERATION_INDEX = 0;
    private static final int FRUIT_INDEX = 1;
    private static final int QUANTITY_INDEX = 2;
    private FruitShopDao fruitShopDao;

    public ProcessCsvDataServiceImpl(FruitShopDao fruitShopDao) {
        this.fruitShopDao = fruitShopDao;
    }

    @Override
    public void processData(List<String> rawData) {
        if (rawData == null) {
            throw new RuntimeException("Incorrect data passed!");
        }
        for (int i = 1; i < rawData.size(); i++) {
            FruitTransaction fruitTransaction = new FruitTransaction();
            String[] csvFields = rawData.get(i).split(SEPARATOR);

            fruitTransaction.setOperation(FruitTransaction.Operation
                    .getOperationFromCode(csvFields[OPERATION_INDEX]));
            fruitTransaction.setFruit(csvFields[FRUIT_INDEX]);
            if (Integer.parseInt(csvFields[QUANTITY_INDEX]) < 0) {
                throw new RuntimeException("Quantity can't be less then 0!");
            }
            fruitTransaction.setQuantity(Integer.parseInt(csvFields[QUANTITY_INDEX]));
            fruitShopDao.add(fruitTransaction);
        }
    }
}
