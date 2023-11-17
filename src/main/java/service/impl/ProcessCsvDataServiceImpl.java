package service.impl;

import db.FruitShopDao;
import model.FruitTransaction;
import service.ProcessCsvDataService;
import java.util.List;

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
        for(int i = 1; i < rawData.size(); i++) {
            FruitTransaction fruitTransaction = new FruitTransaction();
            String[] csvFields = rawData.get(i).split(SEPARATOR);

            fruitTransaction.setOperation(FruitTransaction.Operation.getOperationFromCode(csvFields[OPERATION_INDEX]));
            fruitTransaction.setFruit(csvFields[FRUIT_INDEX]);
            fruitTransaction.setQuantity(Integer.parseInt(csvFields[QUANTITY_INDEX]));

            fruitShopDao.add(fruitTransaction);
        }
    }
}
